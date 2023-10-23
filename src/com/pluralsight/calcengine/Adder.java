package com.pluralsight.calcengine;

public class Adder extends CalculateBase {
    public Adder(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public void calculate() {
        double value = getLeftValue() + getRightValue();
        setResult(value);
    }
}
