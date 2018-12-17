package com.tistory.centauros.kevin;

/**
 * Created by Rene on 2018-12-17.
 * auth : Rene
 */
public class OopAnotherExample {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService();
        int additionResult = calculatorService.calculate('+', 1, 1);
        System.out.println("result :: " + additionResult);
        int subtractionResult = calculatorService.calculate('-', 1, 1);
        System.out.println("result :: " + subtractionResult);
        int multiplicationResult = calculatorService.calculate('*', 1, 1);
        System.out.println("result :: " + multiplicationResult);
        int divitionResult = calculatorService.calculate('/', 8, 4);
        System.out.println("result :: " + divitionResult);

    }
}

class CalculatorService {
    public int calculate(char calculation, int num1, int num2) {
        if (calculation == '+') {
            return num1 + num2;
        } else if (calculation == '-') {
            return num1 - num2;
        } else if (calculation == '*') {
            return num1 * num2;
        } else if (calculation == '/') {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Know Calculation :: " + calculation );
        }
    }

}
