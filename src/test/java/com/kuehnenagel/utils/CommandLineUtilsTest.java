package com.kuehnenagel.utils;

import com.kuehnenagel.CommandLineParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandLineUtilsTest {

    @Test
    void setupCommandLineArguments_shouldThrowException_whenSeparatorHasTwoCharacter() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CommandLineUtils.setupCommandLineArguments(new String[]{"-s", ";;"});
        });
    }

    @Test
    void setupCommandLineArguments_shouldThrowException_whenInputArgumentHasNoValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CommandLineUtils.setupCommandLineArguments(new String[]{"-i", "-o"});
        });
    }

    @Test
    void setupCommandLineArguments_success_whenArgumentsAreValid() {
        CommandLineParser clp = CommandLineUtils.setupCommandLineArguments(new String[]{"-i", "input.csv", "-o", "output.xml"});

        Assertions.assertNotNull(clp);
    }

    @Test
    void setupCommandLineArguments_shouldReturnNull_whenVersionArgumentGiven() {
        CommandLineParser clp = CommandLineUtils.setupCommandLineArguments(new String[]{"-v"});

        Assertions.assertNull(clp);
    }

    @Test
    void setupCommandLineArguments_shouldReturnNull_whenHelperArgumentGiven() {
        CommandLineParser clp = CommandLineUtils.setupCommandLineArguments(new String[]{"-h"});

        Assertions.assertNull(clp);
    }
}
