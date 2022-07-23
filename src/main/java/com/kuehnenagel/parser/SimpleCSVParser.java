package com.kuehnenagel.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This CSV Parser is used for csv files in which each entry in different line.
 * In addition, entry cannot contain quotes to add inner separators.
 */
public class SimpleCSVParser implements CSVParser {

    private final char separator;
    private boolean ignoreEmptyLines = true;

    public SimpleCSVParser() {
        this.separator = DEFAULT_SEPARATOR;
    }

    public SimpleCSVParser(char separator) {
        this.separator = separator;
    }

    @Override
    public char getSeparator() {
        return separator;
    }

    @Override
    public List<String[]> parseFile(File csvFile) throws IOException {
        List<String[]> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (ignoreEmptyLines && line.trim().isEmpty())
                    continue;
                String[] columns = line.split(String.valueOf(this.separator));
                result.add(columns);
            }
        }
        return result;
    }
}
