package com.kuehnenagel;

import com.kuehnenagel.constants.Event;

import java.util.logging.Logger;

public class PointCalculator {
    private static final Logger log = Logger.getLogger((PointCalculator.class.getName()));

    private PointCalculator() {
    }

    /**
     * Calculate event point.
     *
     * @param score is the result of an event. It is measured in seconds for track events,
     *              in meters for throwing events and in centimeters for jumping events.
     *              <ul><li>100m: second</li>
     *              <li>Long jump: centimeter</li>
     *              <li>Shot put: meter</li>
     *              <li>High jump: centimeter</li>
     *              <li>400m: second</li>
     *              <li>110m hurdles: second</li>
     *              <li>discus throw: meter</li>
     *              <li>pole vault: centimeter</li>
     *              <li>javelin throw: meter</li>
     *              <li>1500m: seconds
     * @param event event type
     * @return event point such as 800, 900, 1000.
     */
    public static int calculateEventPoint(double score, Event event) {
        return event.isTrack ? calculatePointForTrack(score, event) : calculatePointForField(score, event);
    }

    private static int calculatePointForTrack(double score, Event event) {
        return (int) (event.A * Math.pow(event.B - score, event.C));
    }

    private static int calculatePointForField(double score, Event event) {
        return (int) (event.A * Math.pow(score - event.B, event.C));
    }

    public static int calculateDecathlonPoint(DecathlonScore ds) {
        return calculateEventPoint(ds.getRace100mScore(), Event.RACE_100M) +
                calculateEventPoint(ds.getLongJumpScore(), Event.LONG_JUMP) +
                calculateEventPoint(ds.getShotPutScore(), Event.SHOT_PUT) +
                calculateEventPoint(ds.getHighJumpScore(), Event.HIGH_JUMP) +
                calculateEventPoint(ds.getRace400mScore(), Event.RACE_400M) +
                calculateEventPoint(ds.getHurdleRace110mScore(), Event.HURDLE_RACE_110M) +
                calculateEventPoint(ds.getDiscusThrowScore(), Event.DISCUS_THROW) +
                calculateEventPoint(ds.getPoleVaultScore(), Event.POLE_VAULT) +
                calculateEventPoint(ds.getJavelinThrowScore(), Event.JAVELIN_THROW) +
                calculateEventPoint(ds.getRace1500mScore(), Event.RACE_1500M);
    }

}
