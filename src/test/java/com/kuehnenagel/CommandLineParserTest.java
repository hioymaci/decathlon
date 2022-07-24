package com.kuehnenagel;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandLineParserTest {

    @Test
    void getArgumentValue_shouldReturnNull_whenArgumentIsAbsent() {
        String[] args = new String[]{"-i", "input.csv"};
        CommandLineParser parse = new CommandLineParser(args);
        String[] values = parse.getArgumentValue("xx");

        assertNull(values);
    }

    @Test
    void getArgumentNames_shouldReturnArgumentNames_whenArgumentsExist() {
        String[] args = new String[]{"-i", "input.csv", "-o", "output.xml"};
        CommandLineParser parse = new CommandLineParser(args);
        Set<String> names = parse.getArgumentNames();

        assertTrue(names.contains("i"));
        assertTrue(names.contains("o"));
    }

    @Test
    void existFlag_shouldReturnTrue_whenFlagExist() {
        String[] args = new String[]{"-v", "-h"};
        CommandLineParser parse = new CommandLineParser(args);
        boolean actual = parse.existFlag("v");

        assertTrue(actual);
    }
}
