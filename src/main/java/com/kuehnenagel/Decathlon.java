package com.kuehnenagel;

import com.kuehnenagel.parser.AthleteParser;
import com.kuehnenagel.writer.AthleteWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;


public class Decathlon {

    private static final Logger log = Logger.getLogger((Decathlon.class.getName()));

    private AthleteParser parser;
    private AthleteWriter writer;
    private List<Athlete> athletes;

    public Decathlon(AthleteParser parser, AthleteWriter writer) {
        this.parser = parser;
        this.writer = writer;
    }

    public void read(File file) throws IOException {
        this.athletes = parser.parse(file);
        for (Athlete athlete : this.athletes) {
            athlete.setTotalScore(PointCalculator.calculateDecathlonPoint(athlete.getDecathlonScore()));
        }
    }

    public void writeToFileAsSorted(File outputFile) {
        Map<Integer, List<Athlete>> athleteMap = new TreeMap<>();
        for (Athlete athlete : this.athletes) {
            List<Athlete> athleteList = athleteMap.get(athlete.getTotalScore());
            if (athleteList == null) {
                List<Athlete> newAthleteList = new ArrayList<>();
                newAthleteList.add(athlete);
                athleteMap.put(athlete.getTotalScore(), newAthleteList);
            } else {
                athleteList.add(athlete);
            }
        }
        if (outputFile == null)
            throw new RuntimeException("Output file cannot be null!");
        if (outputFile.getParentFile() != null) {
            outputFile.getParentFile().mkdirs();
        }
        writer.writeToFileAsSorted(athleteMap, outputFile, this.athletes.size());
    }

    public AthleteParser getParser() {
        return parser;
    }

    public void setParser(AthleteParser parser) {
        this.parser = parser;
    }

    public AthleteWriter getWriter() {
        return writer;
    }

    public void setWriter(AthleteWriter writer) {
        this.writer = writer;
    }

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }
}
