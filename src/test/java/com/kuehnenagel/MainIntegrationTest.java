package com.kuehnenagel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.kuehnenagel.TestUtils.*;

class MainIntegrationTest {

    @Test
    void main_success_whenEverythingFine() throws IOException {
        File input = createTempInput(SAMPLE_FILE_INPUT);
        File output = Files.createTempFile("decathlon_output_temp", ".xml").toFile();
        Main.main(new String[]{"-i", input.getAbsolutePath(), "-o", output.getAbsolutePath()});

        Assertions.assertTrue(output.exists());
    }

    @Test
    void main_success_whenInputFileHasSomeInvalidData() throws IOException {
        File input = createTempInput(SAMPLE_FILE_INPUT_HAS_INVALID_DATA);
        File output = Files.createTempFile("decathlon_output_temp", ".xml").toFile();
        Main.main(new String[]{"-i", input.getAbsolutePath(), "-o", output.getAbsolutePath(), "-k"});

        Assertions.assertTrue(output.exists());
    }
}
