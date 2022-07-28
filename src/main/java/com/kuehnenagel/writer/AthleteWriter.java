package com.kuehnenagel.writer;

import com.kuehnenagel.Athlete;

import java.io.File;
import java.util.Map;
import java.util.TreeSet;

public interface AthleteWriter {
    /**
     * Write athletes to the given file in ascending order by total score.
     *
     * @param athleteMap      athlete map whose key is total score, map's values are list of athletes that has same total score.
     * @param outputFile      output file
     * @param numberOfAthlete number of athlete. It is used to calculate place faster.
     */
    void writeToFileAsSorted(Map<Integer, TreeSet<Athlete>> athleteMap, File outputFile, int numberOfAthlete);
}
