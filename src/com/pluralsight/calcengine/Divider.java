package com.pluralsight.calcengine;

public class Divider extends CalculateBase {
    public Divider(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public void calculate() {
        double value = getRightValue() != 0 ? getLeftValue() / getRightValue() : 0.0d;
        setResult(value);
    }
}
