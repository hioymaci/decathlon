package com.kuehnenagel.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class HelperUtil {


    private static final Logger log = Logger.getLogger((HelperUtil.class.getName()));

    public static void printParsedValued(List<String[]> parsedValues) {
        log.info("Parsed values:");
        for (String[] columns : parsedValues) {
            log.info(() -> Arrays.toString(columns));
        }
    }

    /**
     * Remove element with given index in array.
     */
    public static Object[] remove(Object[] array, int index) {
        if (array.length > 0) {
            if (index >= 0) {
                Object[] copy = (Object[]) Array.newInstance(array.getClass().getComponentType(), array.length - 1);
                if (copy.length > 0) {
                    System.arraycopy(array, 0, copy, 0, index);
                    System.arraycopy(array, index + 1, copy, index, copy.length - index);
                }
                return copy;
            }
        }
        return array;
    }
}
