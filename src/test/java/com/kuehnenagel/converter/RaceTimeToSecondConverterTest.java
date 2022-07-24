package com.kuehnenagel.converter;

import com.kuehnenagel.converters.RaceTimeToSecondConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceTimeToSecondConverterTest {

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
    void convert_shouldConvertToZero_whenInputsIsZero() {
        double actual = RaceTimeToSecondConverter.convert("00:00.00");
        assertEquals(0, actual);
    }

    @Test
    void convert_shouldThrowException_whenInputEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert(" ");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert(null);
        });
    }

    @Test
    void convert_shouldThrowException_whenInputHasAlphabet() {
        assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("1x:1");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsSecondsGreaterThan60() {
        assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("3:60.9");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsSecondsIs60() {
        assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("3:60.00");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsSecondsIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("3:-1");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsMinutesIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("-3:01.2");
        });
    }

    @Test
    void convert_shouldThrowException_whenInputsHasNoSemicolon() {
        assertThrows(IllegalArgumentException.class, () -> {
            double actual = RaceTimeToSecondConverter.convert("555");
        });
    }

}
