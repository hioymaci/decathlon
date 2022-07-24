package com.kuehnenagel;

import com.kuehnenagel.parser.AthleteParser;
import com.kuehnenagel.parser.CsvAthleteParser;
import com.kuehnenagel.parser.SimpleCSVParser;
import com.kuehnenagel.writer.AthleteWriter;
import com.kuehnenagel.writer.XmlAthleteWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static com.kuehnenagel.TestUtils.JOHN_DOE;

public class DecathlonTest {

    static Decathlon createDecathlonInstance() {
        AthleteParser parser = new CsvAthleteParser(new SimpleCSVParser());
        AthleteWriter athleteWriter = new XmlAthleteWriter();
        return new Decathlon(parser, athleteWriter);
    }

    @Test
    void getParser_shouldGetParser_whenever() {
        AthleteParser parser = new CsvAthleteParser(new SimpleCSVParser());
        AthleteWriter athleteWriter = new XmlAthleteWriter();
        Decathlon decathlon = new Decathlon(parser, athleteWriter);
        Assertions.assertEquals(parser, decathlon.getParser());
    }

    @Test
    void setParser_shouldSetParser_whenever() {
        AthleteParser parser = new CsvAthleteParser(new SimpleCSVParser());
        AthleteWriter athleteWriter = new XmlAthleteWriter();
        Decathlon decathlon = new Decathlon(new CsvAthleteParser(new SimpleCSVParser()), athleteWriter);
        decathlon.setParser(parser);
        Assertions.assertEquals(parser, decathlon.getParser());
    }

    @Test
    void getWriter_shouldGetWriter_whenever() {
        AthleteParser parser = new CsvAthleteParser(new SimpleCSVParser());
        AthleteWriter athleteWriter = new XmlAthleteWriter();
        Decathlon decathlon = new Decathlon(parser, athleteWriter);
        Assertions.assertEquals(athleteWriter, decathlon.getWriter());
    }

    @Test
    void setWriter_shouldSetWriter_whenever() {
        AthleteParser parser = new CsvAthleteParser(new SimpleCSVParser());
        AthleteWriter athleteWriter = new XmlAthleteWriter();
        Decathlon decathlon = new Decathlon(parser, new XmlAthleteWriter());
        decathlon.setWriter(athleteWriter);
        Assertions.assertEquals(athleteWriter, decathlon.getWriter());
    }

    @Test
    void setAthletes_shouldSetAthletes_whenever() {
        Decathlon decathlon = createDecathlonInstance();
        List<Athlete> athleteList = Collections.singletonList(new Athlete(JOHN_DOE));
        decathlon.setAthletes(athleteList);
        Assertions.assertEquals(athleteList, decathlon.getAthletes());
    }

    @Test
    void writeToFileAsSorted_shouldThrowException_whenOutputFileIsNull() {
        Decathlon decathlon = createDecathlonInstance();
        decathlon.setAthletes(Collections.singletonList(new Athlete(JOHN_DOE)));
        Assertions.assertThrows(RuntimeException.class, () -> decathlon.writeToFileAsSorted(null));
    }
}
