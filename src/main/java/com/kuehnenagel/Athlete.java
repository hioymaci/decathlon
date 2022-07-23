package com.kuehnenagel;

public class Athlete implements User {

    private String fullName;
    private DecathlonScore decathlonScore;

    private int totalScore;

    public Athlete(String fullName) {
        this.fullName = fullName;
    }

    public Athlete(String fullName, DecathlonScore decathlonScore) {
        this(fullName);
        this.decathlonScore = decathlonScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DecathlonScore getDecathlonScore() {
        return decathlonScore;
    }

    public void setDecathlonScore(DecathlonScore decathlonScore) {
        this.decathlonScore = decathlonScore;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "fullName='" + fullName + '\'' +
                ", decathlonScore=" + decathlonScore +
                ", totalScore=" + totalScore +
                '}';
    }
}
