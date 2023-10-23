package com.pluralsight.calcengine;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        performCalculation();
        executeInteractively();
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
//recover and parse user inputs
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftValue = Double.parseDouble(parts[1]);
        double rightValue = Double.parseDouble(parts[2]);

        CalculateBase calculation = createCalculation(operation, leftValue, rightValue);
        calculation.calculate();

        System.out.println("Operation performed : " + operation);
        System.out.println("Calculation result = " + calculation.getResult());
    }

    private static CalculateBase createCalculation(MathOperation operation, double leftValue, Double rightValue) {
        CalculateBase calculation = null;

        calculation = switch (operation) {
            case ADD:
                yield new Adder(leftValue, rightValue);
            case SUBTRACT:
                yield new Subtracter(leftValue, rightValue);
            case MULTIPLY:
                yield new Multiplier(leftValue, rightValue);
            case DIVIDE:
                yield new Divider(leftValue, rightValue);
        };

        return calculation;
    }

    static void doCalculation(CalculateBase calculation, double leftValue, double rightValue) {
        calculation.setLeftValue(leftValue);
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

    // Working with Classes and Interfaces in Java 11 / chapter7 / Improving calc engine

}
