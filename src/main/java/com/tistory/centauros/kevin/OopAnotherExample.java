package com.tistory.centauros.kevin;

/**
 * Created by Rene on 2018-12-17.
 * auth : Rene
 */
public class OopAnotherExample {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService(new Addition(), new Subtraction(), new Multiplication(), new Division());

        int additionResult = calculatorService.add(5, 1);
        int subtractionResult = calculatorService.subtract(5, 2);
        int multiplicationResult = calculatorService.multiply(6, 2);
        int divisionResult = calculatorService.divide(8, 4);

        System.out.println("      additionResult :: " + additionResult);
        System.out.println("   subtractionResult :: " + subtractionResult);
        System.out.println("multiplicationResult :: " + multiplicationResult);
        System.out.println("      divisionResult :: " + divisionResult);
        System.out.println("");

        FpCalculatorService fpCalculatorService = new FpCalculatorService();

        Calculation addtion = (i1, i2) -> i1 + i2;

        additionResult = fpCalculatorService.calculate(addtion, 5, 1);
        subtractionResult = fpCalculatorService.calculate((i1, i2) -> i1 - i2, 5, 2);
        multiplicationResult = fpCalculatorService.calculate(new Multiplication(), 6,2);
        divisionResult = fpCalculatorService.calculate(new Division(), 8,4);

        System.out.println("      fpAdditionResult :: " + additionResult);
        System.out.println("   fpSubtractionResult :: " + subtractionResult);
        System.out.println("fpMultiplicationResult :: " + multiplicationResult);
        System.out.println("      fpDivisionResult :: " + divisionResult);
        System.out.println("           custom calc :: " + fpCalculatorService.calculate((i1, i2) -> (((i1 + i2) * 2 ) / i2), 20, 5));


    }
}

interface Calculation {
    int calculate(int num1, int num2);
}

class Addition implements Calculation {
    @Override
    public int calculate(int num1, int num2) { return num1 + num2; }
}

class Subtraction implements Calculation {
    @Override
    public int calculate(int num1, int num2) { return num1 - num2; }
}

class Multiplication implements Calculation {
    @Override
    public int calculate(int num1, int num2) { return num1 * num2; }
}

class Division implements Calculation {
    @Override
    public int calculate(int num1, int num2) { return num1 / num2; }
}

class CalculatorService {

    private Calculation addition;
    private Calculation subtraction;
    private Calculation multiplication;
    private Calculation division;

    CalculatorService(Calculation addition, Calculation subtraction, Calculation multiplication, Calculation division) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
        this.division = division;
    }

    public int add(int num1, int num2) {
        if (num1 < 10 && num1 > num2) {
            return addition.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1 :: " + num1 + ", num2 :: " + num2);
        }
    }

    public int subtract(int num1, int num2) {
        return subtraction.calculate(num1, num2);
    }

    public int multiply(int num1, int num2) {
        return multiplication.calculate(num1, num2);
    }

    public int divide(int num1, int num2) {
        return division.calculate(num1, num2);
    }
}

class FpCalculatorService {

    public int calculate(Calculation calculation, int num1, int num2) {
        if (num1 < 30 && num1 > num2) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException("Invalid input num1 :: " + num1 + ", num2 :: " + num2);
        }
    }
}
