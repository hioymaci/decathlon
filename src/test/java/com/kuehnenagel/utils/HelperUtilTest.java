package com.kuehnenagel.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HelperUtilTest {

    @Test
    void getTotalTime_shouldReturnPositiveNumber_whenInputLessThanCurrentTime() {
        double totalTime = HelperUtil.getTotalTime(System.currentTimeMillis() - 1000);
        Assertions.assertTrue(totalTime > 0);
    }

    @Test
    void getTotalTime_shouldNegativeNumber_whenInputGraterThanCurrentTime() {
        double totalTime = HelperUtil.getTotalTime(System.currentTimeMillis() + 1000);
        Assertions.assertTrue(totalTime < 0);
    }
}
