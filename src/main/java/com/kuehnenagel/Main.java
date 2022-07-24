package com.kuehnenagel;

import com.kuehnenagel.constants.Constants;
import com.kuehnenagel.parser.CsvAthleteParser;
import com.kuehnenagel.utils.HelperUtil;
import com.kuehnenagel.writer.XmlAthleteWriter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Decathlon project's aim is to calculate the results of a Decathlon competition.
 * See readme.md for details.
 *
 * @author Halil Ibrahim Oymaci - hioymaci@gmail.com
 */
public class Main {

    private static final String LOG_FILE_PROPERTIES = "/logging.properties";
    private static final String LOG_OUTPUT_FILENAME = "decathlon0.log";
    private static final Logger log = Logger.getLogger(Main.class.getName());
    private static boolean verbose = false;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        setupLogging();
        CommandLineParser clp = setupCommandLineArguments(args);
        log.info("Started Decathlon Score Calculator.");
        try {
            run(clp);
        } catch (Exception e) {
            log.log(Level.SEVERE, "exception is occurred:", e);
        }
        log.info(() -> "Finished Decathlon Score Calculator. Total time: " + HelperUtil.getTotalTime(start));
    }

    public static void run(CommandLineParser clp) throws IOException {
        char inputSeparator = getInputSeparator(clp);
        File inputFile = getInputFile(clp);
        File outputFile = getOutputFile(clp);

        Decathlon decathlon = new Decathlon(new CsvAthleteParser(inputSeparator), new XmlAthleteWriter());
        log.info("Reading input file and calculating scores: " + inputFile.getAbsolutePath());
        decathlon.read(inputFile);
        log.info("Results are being written to the file: " + outputFile.getAbsolutePath());
        decathlon.writeToFileAsSorted(outputFile);
    }

    private static File getOutputFile(CommandLineParser clp) {
        String[] outputFiles = clp.getArgumentValue(Constants.OUTPUT_FILE_ARGUMENT_NAME);
        if (outputFiles != null && outputFiles.length > 0) {
            return new File(outputFiles[0]);
        } else {
            return new File(Constants.DEFAULT_OUTPUT_FILE_PATH);
        }
    }

    private static File getInputFile(CommandLineParser clp) {
        String[] inputFiles = clp.getArgumentValue(Constants.INPUT_FILE_ARGUMENT_NAME);
        if (inputFiles != null && inputFiles.length > 0) {
            return new File(inputFiles[0]);
        } else {
            return new File(Constants.DEFAULT_INPUT_FILEPATH);
        }
    }

    private static char getInputSeparator(CommandLineParser clp) {
        if (clp.existFlag(Constants.INPUT_CSV_SEPARATOR_ARGUMENT_NAME)) {
            return clp.getArgumentValue(Constants.INPUT_CSV_SEPARATOR_ARGUMENT_NAME)[0].charAt(0);
        } else {
            return Constants.DEFAULT_SEPARATOR;
        }
    }

    private static CommandLineParser setupCommandLineArguments(String[] args) {
        CommandLineParser clp = new CommandLineParser(args);
        if (clp.existFlag(Constants.VERSION_ARGUMENT_NAME)) {
            System.out.println("Decathlon score calculator version: " + Constants.VERSION);
            System.exit(2);
        }
        if (args.length < 2 || clp.existFlag(Constants.HELP_ARGUMENT_NAME)) {
            System.out.println(Constants.USAGE);
            System.exit(0);
        }
        validateArguments(clp);

        if (!clp.getArgumentNames().isEmpty()) {
            log.info("Command line arguments:");
            for (String argumentName : clp.getArgumentNames()) {
                log.info(() -> String.format("%s : %s", argumentName, Arrays.toString(clp.getArgumentValue(argumentName))));
            }
        }
        verbose = clp.existFlag(Constants.VERBOSE_OUTPUT_ARGUMENT_NAME);
        if (verbose) {
            log.info("Verbose output. Log level is DEBUG.");
            Logger.getLogger("").setLevel(Level.FINE);
            Handler[] handlers =
                    Logger.getLogger("").getHandlers();
            for (int index = 0; index < handlers.length; index++) {
                handlers[index].setLevel(Level.FINE);
            }
            log.fine("fine log level");
        }
        return clp;
    }

    private static void validateArguments(CommandLineParser clp) {
        for (String argument : clp.getArgumentNames()) {
            String[] value = clp.getArgumentValue(argument);
            if (Constants.INPUT_FILE_ARGUMENT_NAME.equals(argument) || Constants.OUTPUT_FILE_ARGUMENT_NAME.equals(argument) ||
                    Constants.INPUT_CSV_SEPARATOR_ARGUMENT_NAME.equals(argument)) {
                if (value == null || value.length == 0) {
                    throw new IllegalArgumentException("Argument:" + argument + " should have a value after it.");
                }
            }
            if (Constants.INPUT_CSV_SEPARATOR_ARGUMENT_NAME.equals(argument)) {
                if (value[0] == null || value[0].length() != 1) {
                    throw new IllegalArgumentException("Argument:" + argument + " should be one character.");
                }
            }
        }
    }

    private static void setupLogging() {
        try (InputStream in = Main.class.getResourceAsStream(LOG_FILE_PROPERTIES)) {
            LogManager.getLogManager().readConfiguration(in);
            String logPath = System.getProperty("user.home") + File.separator + LOG_OUTPUT_FILENAME;
            log.info(() -> "Program logs can be found at " + logPath);
        } catch (Exception e) {
            System.err.println("Log property file reading error.");
            e.printStackTrace();
        }
    }

    public static boolean isVerbose() {
        return verbose;
    }

    public static void setVerbose(boolean verbose) {
        Main.verbose = verbose;
    }
}
