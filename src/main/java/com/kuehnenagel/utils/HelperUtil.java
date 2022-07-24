package com.kuehnenagel.utils;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class HelperUtil {

    private static final Logger log = Logger.getLogger(HelperUtil.class.getName());

    private HelperUtil() {
    }

    public static void printParsedValued(List<String[]> parsedValues) {
        log.info("Parsed values:");
        for (String[] columns : parsedValues) {
            log.info(() -> Arrays.toString(columns));
        }
    }

    public static double getTotalTime(long start) {
        return (System.currentTimeMillis() - start) / (double) 1000;
    }
}
