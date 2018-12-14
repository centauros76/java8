package com.tistory.centauros;

/**
 * Created by Rene on 2018. 12. 12..
 * auth : Rene
 */
public class Calculator {

    public static void main(String[] args) {
//        final CalculateService calculateService = new CalculateService(new Addition())
        final Calculate calculate = new Addition();
        System.out.println(calculate.calculate(1, 2));


    }
}

class CalculateService {
    private final Calculate calculate;

    CalculateService(final Calculate calculate) {
        this.calculate = calculate;
    }
}

interface Calculate {
    int calculate(final int num1, final int num2);
}

class Addition implements Calculate {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 + num2;
    }
}

class Subtraction implements Calculate {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculate {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 * num2;
    }
}

class Divitioin implements Calculate {
    @Override
    public int calculate(final int num1, final int num2) {
        return num1 / num2;
    }
}




