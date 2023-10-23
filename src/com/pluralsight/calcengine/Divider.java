package com.pluralsight.calcengine;

public class Divider extends CalculateBase {
    @Override
    public void calculate() {
        double value = getRightValue() != 0 ? getLeftValue() / getRightValue() : 0.0d;
        setResult(value);
    }
}
