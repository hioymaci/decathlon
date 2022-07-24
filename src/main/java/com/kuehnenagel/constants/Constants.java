package com.kuehnenagel.constants;

public class Constants {
    public static final String VERSION_ARGUMENT_NAME = "v";
    public static final String HELP_ARGUMENT_NAME = "h";
    public static final String INPUT_FILE_ARGUMENT_NAME = "i";
    public static final String OUTPUT_FILE_ARGUMENT_NAME = "o";
    public static final String INPUT_CSV_SEPARATOR_ARGUMENT_NAME = "s";
    public static final String VERBOSE_OUTPUT_ARGUMENT_NAME = "k";
    public static final String VERSION = "0.0.1";
    public static final String USAGE = "Decathlon point and place calculator.\n" +
            "usage: java -jar decathlon.jar -i inputFile.csv -o outputFile.xml\n" +
            "version: " + VERSION + "\n" +
            "-" + INPUT_FILE_ARGUMENT_NAME + ": input file. It is csv file. Default separator is semicolon ';'. Use -s parameter to change the separator.\n" +
            "-" + OUTPUT_FILE_ARGUMENT_NAME + ": output file. Output file contains all athletes overall decathlon scores, full names and their place. Output file format is xml.\n" +
            "-" + INPUT_CSV_SEPARATOR_ARGUMENT_NAME + ": separator character for input csv file. Default is semicolon ';'. It should be one character.\n" +
            "-" + VERSION_ARGUMENT_NAME + ": print version of the program.\n" +
            "-" + VERBOSE_OUTPUT_ARGUMENT_NAME + ": verbose output.\n" +
            "-" + HELP_ARGUMENT_NAME + ": print this usage information.\n";

    public static final char DEFAULT_SEPARATOR = ';';
    public static final String DEFAULT_INPUT_FILEPATH = "inputs/results.csv";
    public static final String DEFAULT_OUTPUT_FILE_PATH = "decathlon_overall_ranking.xml";

    private Constants() {
    }
}
