package com.kuehnenagel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecathlonScoreFactoryTest {

    @Test
    void generate_shouldGenerateScore_whenInputIsValid() {
        String[] inputs = new String[]{"John Smith", "13.61", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5:25.72"};
        DecathlonScore score = DecathlonScoreFactory.generate(inputs);
        Assertions.assertNotNull(score);
        Assertions.assertTrue(score.getRace100mScore() > 0);
    }

    @Test
    void generate_shouldThrowException_whenInputHasInvalidNumber() {
        String[] inputs = new String[]{"John Smith", "13.xx", "5.00", "9.22", "1.50", "60.39", "16.43", "21.60", "2.60", "35.81", "5:25.72"};

        Assertions.assertThrows(NumberFormatException.class, () -> {
            DecathlonScoreFactory.generate(inputs);
        });
    }
}
