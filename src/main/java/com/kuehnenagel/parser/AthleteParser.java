package com.kuehnenagel.parser;

import com.kuehnenagel.Athlete;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface AthleteParser {
    List<Athlete> parse(File file) throws IOException;
}
