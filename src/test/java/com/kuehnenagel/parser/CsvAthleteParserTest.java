package com.kuehnenagel.parser;

import com.kuehnenagel.Athlete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CsvAthleteParserTest {

    @Test
    void parse_shouldParseAthletes_whenInputValid() throws IOException {
        List<String[]> parsedValues = generateSampleInput();

        CSVParser mockParser = Mockito.mock(CSVParser.class);
        Mockito.when(mockParser.parseFile(Mockito.any())).thenReturn(parsedValues);

        CsvAthleteParser parser = new CsvAthleteParser(mockParser);


        List<Athlete> athletes = parser.parse(null);

        Assertions.assertNotNull(athletes);
        Assertions.assertEquals(2, athletes.size());
    }

    private List<String[]> generateSampleInput() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"John Smith", "13.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5:25.72"});
        list.add(new String[]{"Halil Oymaci", "12.61", "4.00", "10.22", "2.50", "60.39", "16.43", "22.60", "2.65", "35.81", "4:25.72"});
        return list;
    }

}
