package com.kuehnenagel.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface CSVParser extends FileParser {
    /**
     * The default separator to use if none is supplied to the constructor.
     */
    char DEFAULT_SEPARATOR = ',';

    /**
     * @return The default separator for this parser.
     */
    char getSeparator();

    /**
     * Parses csv File and returns an array of elements.
     *
     * @param file CSV File to be parsed.
     * @return The list of elements
     * @throws IOException If bad things happen during the read
     */
    List<String[]> parseFile(File file) throws IOException;
}
