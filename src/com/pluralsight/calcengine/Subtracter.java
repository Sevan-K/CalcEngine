package com.pluralsight.calcengine;

public class Subtracter extends CalculateBase {
    public Subtracter(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public void calculate() {
        double value = getLeftValue() - getRightValue();
        setResult(value);
    }

}
