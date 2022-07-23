package com.kuehnenagel;

import com.kuehnenagel.events.Event;
import com.kuehnenagel.events.Events;

import java.util.logging.Logger;

public class PointCalculator {
    private static final Logger log = Logger.getLogger((PointCalculator.class.getName()));
    static int a = 0;

    private PointCalculator() {
    }

    public static int calculatePointForTrack(double performance, Event event) {
        log.info(() -> "calculating " + event.label);
        return (int) (event.A * Math.pow(event.B - performance, event.C));
    }

    public static int calculatePointForField(double performance, Events event) {
        return (int) (event.getA() * Math.pow(performance - event.getB(), event.getC()));
    }
}
