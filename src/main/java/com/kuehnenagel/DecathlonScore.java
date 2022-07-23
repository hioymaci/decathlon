package com.kuehnenagel;

public class DecathlonScore {
    private double race100mScore;
    private double longJumpScore;
    private double shotPutScore;
    private double highJumpScore;
    private double race400mScore;
    private double hurdleRace110mScore;
    private double discusThrowScore;
    private double poleVaultScore;
    private double javelinThrowScore;
    private double race1500mScore;

    public double getRace100mScore() {
        return race100mScore;
    }

    public void setRace100mScore(double race100mScore) {
        this.race100mScore = race100mScore;
    }

    public double getLongJumpScore() {
        return longJumpScore;
    }

    public void setLongJumpScore(double longJumpScore) {
        this.longJumpScore = longJumpScore;
    }

    public double getShotPutScore() {
        return shotPutScore;
    }

    public void setShotPutScore(double shotPutScore) {
        this.shotPutScore = shotPutScore;
    }

    public double getHighJumpScore() {
        return highJumpScore;
    }

    public void setHighJumpScore(double highJumpScore) {
        this.highJumpScore = highJumpScore;
    }

    public double getRace400mScore() {
        return race400mScore;
    }

    public void setRace400mScore(double race400mScore) {
        this.race400mScore = race400mScore;
    }

    public double getHurdleRace110mScore() {
        return hurdleRace110mScore;
    }

    public void setHurdleRace110mScore(double hurdleRace110mScore) {
        this.hurdleRace110mScore = hurdleRace110mScore;
    }

    public double getDiscusThrowScore() {
        return discusThrowScore;
    }

    public void setDiscusThrowScore(double discusThrowScore) {
        this.discusThrowScore = discusThrowScore;
    }

    public double getPoleVaultScore() {
        return poleVaultScore;
    }

    public void setPoleVaultScore(double poleVaultScore) {
        this.poleVaultScore = poleVaultScore;
    }

    public double getJavelinThrowScore() {
        return javelinThrowScore;
    }

    public void setJavelinThrowScore(double javelinThrowScore) {
        this.javelinThrowScore = javelinThrowScore;
    }

    public double getRace1500mScore() {
        return race1500mScore;
    }

    public void setRace1500mScore(double race1500mScore) {
        this.race1500mScore = race1500mScore;
    }

    @Override
    public String toString() {
        return "DecathlonScore{" +
                "race100mScore=" + race100mScore +
                ", longJumpScore=" + longJumpScore +
                ", shotPutScore=" + shotPutScore +
                ", highJumpScore=" + highJumpScore +
                ", race400mScore=" + race400mScore +
                ", hurdleRace110mScore=" + hurdleRace110mScore +
                ", discusThrowScore=" + discusThrowScore +
                ", poleVaultScore=" + poleVaultScore +
                ", javelinThrowScore=" + javelinThrowScore +
                ", race1500mScore=" + race1500mScore +
                '}';
    }
}
