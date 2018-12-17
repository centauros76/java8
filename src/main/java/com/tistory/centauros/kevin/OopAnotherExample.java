package com.tistory.centauros.kevin;

/**
 * Created by Rene on 2018-12-17.
 * auth : Rene
 */
public class OopAnotherExample {
    public static void main(String[] args) {
        final CalculatorService calculatorService = new CalculatorService();
        System.out.println(calculatorService.calculate(1,2));
    }
}

class CalculatorService {
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }

}
