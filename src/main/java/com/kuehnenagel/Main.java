package com.kuehnenagel;

import com.kuehnenagel.parser.CsvAthleteParser;
import com.kuehnenagel.parser.SimpleCSVParser;
import com.kuehnenagel.utils.CommandLineUtils;
import com.kuehnenagel.utils.HelperUtil;
import com.kuehnenagel.writer.XmlAthleteWriter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
        setupLogger();
        CommandLineParser clp = CommandLineUtils.setupCommandLineArguments(args);
        if (null == clp) {
            // program terminated due to command line arguments.
            return;
        }
        log.info("Started Decathlon Score Calculator.");
        try {
            run(clp);
        } catch (Exception e) {
            log.log(Level.SEVERE, "exception is occurred:", e);
        }
        log.info(() -> "Finished Decathlon Score Calculator. Total time: " + HelperUtil.getTotalTime(start));
    }

    public static void run(CommandLineParser clp) throws IOException {
        char inputSeparator = CommandLineUtils.getInputSeparator(clp);
        File inputFile = CommandLineUtils.getInputFile(clp);
        File outputFile = CommandLineUtils.getOutputFile(clp);

        Decathlon decathlon = new Decathlon(new CsvAthleteParser(new SimpleCSVParser(inputSeparator)), new XmlAthleteWriter());
        log.info("Reading input file and calculating scores: " + inputFile.getAbsolutePath());
        decathlon.read(inputFile);
        log.info(() -> String.format("There are %d athletes in input file.", decathlon.getAthletes().size()));
        log.info("Results are being written to the file: " + outputFile.getAbsolutePath());
        decathlon.writeToFileAsSorted(outputFile);
    }

    private static void setupLogger() {
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
