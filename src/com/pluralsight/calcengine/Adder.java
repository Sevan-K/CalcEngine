package com.pluralsight.calcengine;

public class Adder extends CalculateBase {
    @Override
    public void calculate() {
        double value = getLeftValue() + getRightValue();
        setResult(value);
    }
}
