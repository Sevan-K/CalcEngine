package com.pluralsight.calcengine;

public class Multiplier extends CalculateBase  {
@Override
    public void calculate(){
    double value = getLeftValue() * getRightValue();
    setResult(value);
}
}
