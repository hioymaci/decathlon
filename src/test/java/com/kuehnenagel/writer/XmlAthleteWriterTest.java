package com.kuehnenagel.writer;

import com.kuehnenagel.Athlete;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertThrows;

class XmlAthleteWriterTest {

    @Test
    void writeToFileAsSorted_shouldThrowException_whenFilePathIsInvalid() {
        XmlAthleteWriter writer = new XmlAthleteWriter();
        Map<Integer, TreeSet<Athlete>> athleteMap = new TreeMap<>();
        athleteMap.put(1000, new TreeSet<>(Collections.singleton(new Athlete("Halil Oymaci"))));
        athleteMap.put(2000, new TreeSet<>(Collections.singleton(new Athlete("Mehmet Parlak"))));
        File output = new File("A:/decathlon_output.xml");

        assertThrows(RuntimeException.class, () -> writer.writeToFileAsSorted(athleteMap, output, 2));
    }
}
