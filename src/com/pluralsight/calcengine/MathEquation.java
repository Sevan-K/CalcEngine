package com.pluralsight.calcengine;

public class MathEquation {
    // states
    private double leftValue;
    private double rightValue;
    private char opCode;
    private double result;

    //    static fields ar automatically set to 0
    private static int numberOfCalculations;

    private static double sumOfResults;


    // constructors
    public MathEquation() {
    }

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(double leftValue, double rightValue, char opCode) {
        this.opCode = opCode;
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    // methods
    void execute() {
        // enhanced switch
        result = switch (opCode) {
            case 'a':
                yield leftValue + rightValue;
            case 's':
                yield leftValue - rightValue;
            case 'm':
                yield leftValue * rightValue;
            case 'd':
                yield rightValue != 0 ? leftValue / rightValue : 0.0d;
            default:
                yield 0.0d;
        };

        // update static states for average calculation
        numberOfCalculations++;
        sumOfResults += result;
    }

    // execute overload
    public void execute(double leftValue, double rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;

        execute();
    }

    public void execute(int leftValue, int rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;

        execute();

        result = (int)result; // to get rid of decimal part
    }

    //    calculate average result
    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }

    // setters
    public void setLeftValue(double leftValue) {
        this.leftValue = leftValue;
    }

    public void setRightValue(double rightValue) {
        this.rightValue = rightValue;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    // getters
    public double getResult() {
        return result;
    }
}
