package com.kuehnenagel.parser;

import com.kuehnenagel.Athlete;
import com.kuehnenagel.DecathlonScore;
import com.kuehnenagel.DecathlonScoreFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvAthleteParser implements AthleteParser {

    private static final Logger log = Logger.getLogger((AthleteParser.class.getName()));

    private final char separator;

    public CsvAthleteParser(char separator) {
        this.separator = separator;
    }

    /**
     * Parse csv file that contains athletes' decathlon's scores.
     *
     * @param csvFile csv file in which each row contain 11 values: athlete's full name, 100-meter dash score as seconds,
     *                long jump score as meter, shot put score as meter, high jump score as meter, 400-meter as seconds,
     *                hurtdle race 110-meter as seconds, discus throw as meter, pole vault score as meter, javelin throw
     *                as meter, 1500-meter run in 'm:ss' format in which m: minutes, ss: seconds.
     * @return list of parsed athletes.
     * @throws IOException if file error occurs.
     */
    @Override
    public List<Athlete> parse(File csvFile) throws IOException {
        List<String[]> parsedValues;
        CSVParser csvParser = new SimpleCSVParser(separator);
        parsedValues = csvParser.parseFile(csvFile);
//        HelperUtil.printParsedValued(parsedValues);
        return parseAthletes(parsedValues);
    }

    private List<Athlete> parseAthletes(List<String[]> parsedValues) {
        List<Athlete> athletes = new ArrayList<>();
        for (int row = 0; row < parsedValues.size(); row++) {
            String[] columns = parsedValues.get(row);
            if (columns.length != 11) {
                log.warning(String.format("Row:%d has not 11 values which are separatored with '%c'.", row + 1, separator));
                continue;
            }
            String fullName = columns[0];
            try {
                DecathlonScore decathlonScore = DecathlonScoreFactory.generate(columns);
                Athlete athlete = new Athlete(fullName, decathlonScore);
                athletes.add(athlete);
            } catch (NumberFormatException ex) {
                log.log(Level.WARNING, "Number format error!", ex);
            } catch (IllegalArgumentException ex) {
                log.log(Level.WARNING, "Illegal argument!", ex);
            }
        }
        return athletes;
    }
}
