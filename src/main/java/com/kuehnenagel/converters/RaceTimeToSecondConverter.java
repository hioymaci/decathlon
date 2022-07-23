package com.kuehnenagel.converters;

public class RaceTimeToSecondConverter {

    private RaceTimeToSecondConverter() {
    }

    /**
     * Convert a race time like as format m:ss to seconds.
     *
     * @param raceTime race finished time as format: m:ss to seconds. For example '5:12.34' converted to 312.34.
     * @return race time as seconds
     * @throws IllegalArgumentException if the input is invalid.
     */
    public static double convert(String raceTime) {
        if (raceTime == null || raceTime.trim().isEmpty())
            throw new IllegalArgumentException("Input should not be empty!");
        String[] parts = raceTime.trim().split(":");
        if (parts.length != 2)
            throw new IllegalArgumentException("Input should have only one colon character.");
        String minutesStr = parts[0];
        String secondsStr = parts[1];
        try {
            double minutes = Double.parseDouble(minutesStr);
            if (minutes < 0)
                throw new IllegalArgumentException("Minutes in input should be nonnegative.");
            double seconds = Double.parseDouble(secondsStr);
            if (seconds < 0 || seconds >= 60) {
                throw new IllegalArgumentException("Seconds in input should be less than 60 and be nonnegative.");
            }
            return 60 * minutes + seconds;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Input format is invalid. Format should be m:ss");
        }
    }
}
