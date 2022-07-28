package com.kuehnenagel.parser;

import com.kuehnenagel.Athlete;
import com.kuehnenagel.DecathlonScore;
import com.kuehnenagel.DecathlonScoreFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AthleteParser {

    private static final Logger log = Logger.getLogger(AthleteParser.class.getName());

    /**
     * Convert string's to Athlete objects.
     *
     * @param parsedValues Each element in list contains 11 values: athlete's full name, 100-meter dash score as seconds,
     *                     long jump score as meter, shot put score as meter, high jump score as meter, 400-meter as seconds,
     *                     hurdle race 110-meter as seconds, discus throw as meter, pole vault score as meter, javelin throw
     *                     as meter, 1500-meter run in 'm:ss' format in which m: minutes, ss: seconds.
     * @return list of parsed athletes.
     */
    public List<Athlete> parseAthletes(List<String[]> parsedValues) {
        List<Athlete> athletes = new ArrayList<>();
        for (int row = 0; row < parsedValues.size(); row++) {
            String[] columns = parsedValues.get(row);
            if (columns.length != 11) {
                log.warning(String.format("Row:%d has not 11 values which are separated.", row + 1));
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
