package com.pluralsight.calcengine;


public class Main {
    public static void main(String[] args) {
        performCalculation();
    }

    static void doCalculation(CalculateBase calculation, double leftvalue, double rightValue) {
        calculation.setLeftValue(leftvalue);
        calculation.setRightValue(rightValue);
        calculation.calculate();

        System.out.println("Calculation result = " + calculation.getResult());
    }

    private static void performCalculation() {
        double[] leftValues = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightValues = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCode = {'d', 'a', 's', 'm'};

        int numberOfCalculation = opCode.length;

        double[] results = new double[numberOfCalculation];

        MathEquation[] equations = new MathEquation[numberOfCalculation];

        for (int i = 0; i < numberOfCalculation; i++) {
            equations[i] = new MathEquation(leftValues[i], rightValues[i], opCode[i]);
        }

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

        System.out.println();
        System.out.println("Using execute overload");

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overload result with doubles: = " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overload result with ints: = " + equationOverload.getResult());
        // widening conversion happened
    }

    //    old code
    private static MathEquation create(double leftValue, double rightValue, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setLeftValue(leftValue);
        equation.setRightValue(rightValue);
        equation.setOpCode(opCode);
        equation.execute();

        return equation;

    }

    // Working with Classes and Interfaces in Java 11 / chapter6 / Improving calc engine

}
