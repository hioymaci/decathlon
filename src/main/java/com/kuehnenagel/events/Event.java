package com.kuehnenagel.events;

import java.util.HashMap;
import java.util.Map;

public enum Event {
    RACE_100M("100-meter dash", true, 25.4347, 18, 1.81),
    LONG_JUMP("Long jump", false, 0.14354, 220, 1.4),
    SHOT_PUT("Shot put", false, 51.39, 1.5, 1.05),
    HIGH_JUMP("High jump", false, 0.8465, 75, 1.42),
    RACE_400M("400-meter dash", true, 1.53775, 82, 1.81),
    HURDLE_RACE_110M("110-meter hurdle race", true, 5.74352, 28.5, 1.92),
    DISCUS_THROW("Discus throw", false, 12.91, 4, 1.1),
    POLE_VAULT("Pole Vault", false, 0.2797, 100, 1.35),
    JAVELIN_THROW("Javelin Throw", false, 10.14, 7, 1.08),
    RACE_1500M("1500-meter run", true, 0.03768, 480, 1.85);

    private static final Map<String, Event> ENUM_MAP = new HashMap<>();

    static {
        for (Event e : values()) {
            ENUM_MAP.put(e.label, e);
        }
    }

    public final String label;

    // If an event is not track, it is field event.
    public final boolean isTrack;
    public final double A;
    public final double B;
    public final double C;

    private Event(String label, boolean isTrack, double A, double B, double C) {
        this.label = label;
        this.isTrack = isTrack;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public static Event get(String label) {
        return ENUM_MAP.get(label);
    }
}

