package com.kuehnenagel;

import com.kuehnenagel.parser.AthleteParser;
import com.kuehnenagel.writer.AthleteWriter;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;


public class Decathlon {

    private static final Logger log = Logger.getLogger(Decathlon.class.getName());

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
        Map<Integer, Set<Athlete>> athleteMap = new TreeMap<>();
        for (Athlete athlete : this.athletes) {
            Set<Athlete> athleteList = athleteMap.get(athlete.getTotalScore());
            if (athleteList == null) {
                Set<Athlete> newAthleteList = new TreeSet<>(new AthleteNameComparator());
                newAthleteList.add(athlete);
                athleteMap.put(athlete.getTotalScore(), newAthleteList);
            } else {
                athleteList.add(athlete);
            }
        }
        if (Main.isVerbose()) {
            printAthletes(athleteMap);
        }
        if (outputFile == null) {
            throw new RuntimeException("Output file cannot be null!");
        }
        if (outputFile.getParentFile() != null) {
            outputFile.getParentFile().mkdirs();
        }
        writer.writeToFileAsSorted(athleteMap, outputFile, this.athletes.size());
    }

    private void printAthletes(Map<Integer, Set<Athlete>> athleteMap) {
        int place = this.athletes.size();
        for (Map.Entry<Integer, Set<Athlete>> entry : athleteMap.entrySet()) {
            Integer score = entry.getKey();
            Set<Athlete> athleteList = entry.getValue();
            String placeStr = String.valueOf(place);
            if (athleteList.size() > 1) {
                placeStr = String.format("%d-%d", place - athleteList.size() + 1, place);
            }
            place -= athleteList.size();
            for (Athlete athlete : athleteList) {
                log.fine(String.format("%5s - %04d - %s", placeStr, score, athlete.getFullName()));
            }
        }
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
