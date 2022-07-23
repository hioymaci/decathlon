package com.kuehnenagel.events;

public class Race100m implements Events {
    private static final double A = 25.4347;
    private static final double B = 18;
    private static final double C = 1.81;

    @Override
    public double getA() {
        return A;
    }

    @Override
    public double getB() {
        return B;
    }

    @Override
    public double getC() {
        return C;
    }
}
