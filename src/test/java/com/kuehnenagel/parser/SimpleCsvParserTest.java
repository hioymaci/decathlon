package com.kuehnenagel.parser;

import com.kuehnenagel.constants.Constants;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.kuehnenagel.TestUtils.SAMPLE_FILE_INPUT;
import static com.kuehnenagel.TestUtils.createTempInput;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimpleCsvParserTest {

    @Test
    void getSeparator_shouldGetDefaultSeparator_whenParseHasNoArgument() {
        SimpleCSVParser parse = new SimpleCSVParser();

        assertEquals(CSVParser.DEFAULT_SEPARATOR, parse.getSeparator());
    }

    @Test
    void parseFile_shouldParseFile_whenFileIsValid() throws IOException {
        SimpleCSVParser parse = new SimpleCSVParser(Constants.DEFAULT_SEPARATOR);

        List<String[]> parsedContent = parse.parseFile(createTempInput(SAMPLE_FILE_INPUT));

        assertNotNull(parsedContent);
        assertEquals(2, parsedContent.size());
        assertEquals(11, parsedContent.get(0).length);
    }
}
