package com.kuehnenagel;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestUtils {

    public static final String SAMPLE_FILE_INPUT = "John Smith;13.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5:25.72 \n" +
            "Jane Doe;13.04;4.53;7.79;1.55;69.72;18.74;24.20;2.40;28.20;6:50.76 ";

    public static final String SAMPLE_FILE_INPUT_HAS_INVALID_DATA = "John Smith;13.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5:25.72 \n" +
            "Jane Doe;13.04;4.53;7.79;1.55;69.72;18.74;24.20;2.40;28.20;6:50.76 \n" +
            "Halil Yilmaz;1x.04;4.d3;7.79;1.55;69.72;18.74;24.20;2.40;28.20;6:50.76 \n" +
            "Michael Ger;13.04;4.53;7.79;1.55;69.72;18.74;24.20;2.40;28.20;65076 \n" +
            "aaa bbb ccc dd ee ff\n" +
            "   \n" +
            "John Doe;13.04;4.53;7.79;1.55;69.72;18.74;24.20;2.40;28.20;6:50.76 \n";

    public static final String JOHN_DOE = "John Doe";

    public static File createTempInput(String fileContent) throws IOException {
        Path tempFile = Files.createTempFile("decathlon_input_temp", ".csv");
        Files.write(tempFile, fileContent.getBytes(StandardCharsets.UTF_8));
        return tempFile.toFile();
    }
}
