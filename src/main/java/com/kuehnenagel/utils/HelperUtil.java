package com.kuehnenagel.utils;

public class HelperUtil {

    private HelperUtil() {
    }

    public static double getTotalTime(long start) {
        return (System.currentTimeMillis() - start) / (double) 1000;
    }
}
