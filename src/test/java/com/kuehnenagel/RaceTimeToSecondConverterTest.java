package com.kuehnenagel;

import com.kuehnenagel.converters.RaceTimeToSecondConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaceTimeToSecondConverterTest {

    @Test
    void convert_shouldConvertToSeconds_whenInputValid() {
        assertAll("convert",
                () -> assertEquals(312.34, RaceTimeToSecondConverter.convert("5:12.34")),
                () -> assertEquals(83.4, RaceTimeToSecondConverter.convert("1:23.40")),
                () -> assertEquals(1.01, RaceTimeToSecondConverter.convert("0:01.01"))
        );
    }

    @Test
    void convert_shouldConvertToSeconds_whenInputHasLeadingSpaces() {
        double actual = RaceTimeToSecondConverter.convert(" 4:32.10 ");
        assertEquals(272.10, actual);
    }

    @Test
    void convert_shouldConvertToSeconds_whenInputHasLeadingZeros() {
        double actual = RaceTimeToSecondConverter.convert("01:02.12");
        assertEquals(62.12, actual);
    }

    @Test
    void convert_shouldThrowException_whenInputEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert(" ");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert(null);
        });
    }

    @Test
    void convert_shouldThrowException_whenInputHasAlphabet() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("1x:1");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsSecondsGreaterThan60() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("3:60.9");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsSecondsIs60() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("3:60.00");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsSecondsIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("3:-1");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsMinutesIsNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("-3:01.2");
        });
    }

    @Test
    void convert_shouldConvertToZero_whenInputsIsZero() {
        double actual = RaceTimeToSecondConverter.convert("00:00.00");
        assertEquals(0, actual);
    }

}
