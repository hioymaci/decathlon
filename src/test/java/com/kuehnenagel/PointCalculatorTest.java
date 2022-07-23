package com.kuehnenagel;

import com.kuehnenagel.events.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PointCalculatorTest {

    @Test
    void calculatePointForTrack_return1000_whenInputsValid() {
        int actual = PointCalculator.calculatePointForTrack(10.395, Event.RACE_100M);

        assertEquals(1000, actual);
    }
}
