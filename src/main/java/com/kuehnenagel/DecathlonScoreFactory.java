package com.kuehnenagel;

import com.kuehnenagel.converters.RaceTimeToSecondConverter;

public class DecathlonScoreFactory {

    /**
     * @param values first element is name, next 9 elements are events cores as double,
     *               last element is race time score as format 'm:ss'.
     * @return decathlon values for all events
     * @throws NumberFormatException if any score is not a number
     */
    public static DecathlonScore generate(String[] values) {
        DecathlonScore decathlonScore = new DecathlonScore();
        decathlonScore.setRace100mScore(Double.parseDouble(values[1]));
        decathlonScore.setLongJumpScore(Double.parseDouble(values[2]) * 100);
        decathlonScore.setShotPutScore(Double.parseDouble(values[3]));
        decathlonScore.setHighJumpScore(Double.parseDouble(values[4]) * 100);
        decathlonScore.setRace400mScore(Double.parseDouble(values[5]));
        decathlonScore.setHurdleRace110mScore(Double.parseDouble(values[6]));
        decathlonScore.setDiscusThrowScore(Double.parseDouble(values[7]));
        decathlonScore.setPoleVaultScore(Double.parseDouble(values[8]) * 100);
        decathlonScore.setJavelinThrowScore(Double.parseDouble(values[9]));
        decathlonScore.setRace1500mScore(RaceTimeToSecondConverter.convert(values[10]));
        return decathlonScore;
    }

    public static DecathlonScore generate(double[] scores) {
        DecathlonScore decathlonScore = new DecathlonScore();
        decathlonScore.setRace100mScore(scores[1]);
        decathlonScore.setLongJumpScore(scores[2]);
        decathlonScore.setShotPutScore(scores[3]);
        decathlonScore.setHighJumpScore(scores[4]);
        decathlonScore.setRace400mScore(scores[5]);
        decathlonScore.setHurdleRace110mScore(scores[6]);
        decathlonScore.setDiscusThrowScore(scores[7]);
        decathlonScore.setPoleVaultScore(scores[8]);
        decathlonScore.setJavelinThrowScore(scores[9]);
        decathlonScore.setRace1500mScore(scores[10]);
        return decathlonScore;
    }
}
