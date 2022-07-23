package com.kuehnenagel.parser;

import com.kuehnenagel.Athlete;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AthleteParser {

    /**
     * Read input file and parsed it to list of athletes.
     *
     * @param file input file
     * @return list of athletes
     * @throws IOException if file error occurs.
     */
    List<Athlete> parse(File file) throws IOException;
}
