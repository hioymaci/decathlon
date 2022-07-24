package com.kuehnenagel.writer;

import com.kuehnenagel.Athlete;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static com.kuehnenagel.TestUtils.JOHN_DOE;
import static org.junit.jupiter.api.Assertions.assertThrows;

class XmlAthleteWriterTest {

    @Test
    void writeToFileAsSorted_shouldThrowException_whenFilePathIsInvalid() {
        XmlAthleteWriter writer = new XmlAthleteWriter();
        Map<Integer, Set<Athlete>> athleteMap = new TreeMap<>();
        athleteMap.put(1000, Collections.singleton(new Athlete("Halil Oymaci")));
        athleteMap.put(2000, Collections.singleton(new Athlete(JOHN_DOE)));
        File output = new File("A:/decathlon_output.xml");

        assertThrows(RuntimeException.class, () -> writer.writeToFileAsSorted(athleteMap, output, 2));
    }
}
