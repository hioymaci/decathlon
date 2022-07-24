package com.kuehnenagel.utils;

import com.kuehnenagel.CommandLineParser;
import com.kuehnenagel.Main;
import com.kuehnenagel.constants.Constants;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommandLineUtils {

    private static final Logger log = Logger.getLogger(CommandLineUtils.class.getName());

    private CommandLineUtils() {
    }

    public static File getOutputFile(CommandLineParser clp) {
        String[] outputFiles = clp.getArgumentValue(Constants.OUTPUT_FILE_ARGUMENT_NAME);
        if (outputFiles != null && outputFiles.length > 0) {
            return new File(outputFiles[0]);
        } else {
            return new File(Constants.DEFAULT_OUTPUT_FILE_PATH);
        }
    }

    public static File getInputFile(CommandLineParser clp) {
        String[] inputFiles = clp.getArgumentValue(Constants.INPUT_FILE_ARGUMENT_NAME);
        if (inputFiles != null && inputFiles.length > 0) {
            return new File(inputFiles[0]);
        } else {
            return new File(Constants.DEFAULT_INPUT_FILEPATH);
        }
    }

    public static char getInputSeparator(CommandLineParser clp) {
        if (clp.existFlag(Constants.INPUT_CSV_SEPARATOR_ARGUMENT_NAME)) {
            return clp.getArgumentValue(Constants.INPUT_CSV_SEPARATOR_ARGUMENT_NAME)[0].charAt(0);
        } else {
            return Constants.DEFAULT_SEPARATOR;
        }
    }

    /**
     * Set command line arguments
     *
     * @param args command line arguments which come from main method
     * @return null if program should be exited
     */
    public static CommandLineParser setupCommandLineArguments(String[] args) {
        CommandLineParser clp = new CommandLineParser(args);
        if (clp.existFlag(Constants.VERSION_ARGUMENT_NAME)) {
            System.out.println("Decathlon score calculator version: " + Constants.VERSION);
            return null;
        }
        if (args.length < 2 || clp.existFlag(Constants.HELP_ARGUMENT_NAME)) {
            System.out.println(Constants.USAGE);
            return null;
        }
        validateArguments(clp);

        if (!clp.getArgumentNames().isEmpty()) {
            log.info("Command line arguments:");
            for (String argumentName : clp.getArgumentNames()) {
                log.info(() -> String.format("%s : %s", argumentName, Arrays.toString(clp.getArgumentValue(argumentName))));
            }
        }
        Main.setVerbose(clp.existFlag(Constants.VERBOSE_OUTPUT_ARGUMENT_NAME));
        if (Main.isVerbose()) {
            log.info("Verbose output. Log level is DEBUG.");
            Logger.getLogger("").setLevel(Level.FINE);
            Handler[] handlers =
                    Logger.getLogger("").getHandlers();
            for (Handler handler : handlers) {
                handler.setLevel(Level.FINE);
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
}
