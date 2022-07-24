package com.kuehnenagel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.kuehnenagel.TestUtils.JOHN_DOE;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AthleteTest {

    @Test
    void toString_shouldContainAllFields_whenever() {

        Athlete athlete = new Athlete(JOHN_DOE);

        String actual = athlete.toString();

        Field[] allFields = Athlete.class.getDeclaredFields();

        Arrays.stream(allFields).forEach(f -> assertTrue(actual.contains(f.getName()), f.getName() + " doesn't exist in toString()."));
    }

    @Test
    void setFullName_shouldSetAthleteFullName_whenever() {
        Athlete athlete = new Athlete(JOHN_DOE);

        String newFullName = "Halil Oymaci";
        athlete.setFullName(newFullName);

        Assertions.assertEquals(newFullName, athlete.getFullName());
    }


    @Test
    void setDecathlonScore_shouldSetDecathlonScore_whenever() {
        Athlete athlete = new Athlete(JOHN_DOE);

        DecathlonScore ds = new DecathlonScore();
        athlete.setDecathlonScore(ds);

        Assertions.assertEquals(ds, athlete.getDecathlonScore());
    }
}
