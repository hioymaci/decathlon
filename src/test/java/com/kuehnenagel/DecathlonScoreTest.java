package com.kuehnenagel;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DecathlonScoreTest {

    @Test
    void toString_shouldContainAllFields_whenever() {

        DecathlonScore ds = new DecathlonScore();
        ds.setRace100mScore(123);

        String actual = ds.toString();

        Field[] allFields = DecathlonScore.class.getDeclaredFields();

        Arrays.stream(allFields).forEach(f -> assertTrue(actual.contains(f.getName()), f.getName() + " doesn't exist in toString()."));
    }
}
