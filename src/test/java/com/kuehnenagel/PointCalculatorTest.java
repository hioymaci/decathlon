package com.kuehnenagel;

import com.kuehnenagel.constants.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PointCalculatorTest {

    @Test
    void calculateEventPoint_returnFullPoint_whenRace100m() {
        int actual = PointCalculator.calculateEventPoint(10.395, Event.RACE_100M);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenLongJump() {
        int actual = PointCalculator.calculateEventPoint(776, Event.LONG_JUMP);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenShotPut() {
        int actual = PointCalculator.calculateEventPoint(18.40, Event.SHOT_PUT);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenHighJump() {
        int actual = PointCalculator.calculateEventPoint(220.77, Event.HIGH_JUMP);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenRace400m() {
        int actual = PointCalculator.calculateEventPoint(46.17, Event.RACE_400M);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenHurdleRace110m() {
        int actual = PointCalculator.calculateEventPoint(13.80, Event.HURDLE_RACE_110M);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenDiscusThrow() {
        int actual = PointCalculator.calculateEventPoint(56.17, Event.DISCUS_THROW);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenPoleVault() {
        int actual = PointCalculator.calculateEventPoint(528.63, Event.POLE_VAULT);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenJavelinThrow() {
        int actual = PointCalculator.calculateEventPoint(77.19, Event.JAVELIN_THROW);
        assertEquals(1000, actual);
    }

    @Test
    void calculateEventPoint_returnFullPoint_whenRace1500m() {
        int actual = PointCalculator.calculateEventPoint(233.79, Event.RACE_1500M);
        assertEquals(1000, actual);
    }

}
