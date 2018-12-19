package com.tistory.centauros.kevin.functionalInterface;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by Rene on 2018-12-19.
 * auth : Rene
 */
public class SupplierExamples {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello";

        System.out.println(supplier.get() + " world");

        long start = System.currentTimeMillis();
        printValue(1, getVeryExpensiveValue());
        printValue(-1, getVeryExpensiveValue());
        printValue(-2, getVeryExpensiveValue());
        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000) + " seconds");

        start = System.currentTimeMillis();
        lazyEvalPrintValue(1, () -> getVeryExpensiveValue());
        lazyEvalPrintValue(-1, () -> getVeryExpensiveValue());
        lazyEvalPrintValue(-2, () -> getVeryExpensiveValue());
        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000) + " seconds");

    }

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Rene";
    }

    private static void printValue (int number, String value) {
        if (number >= 0) {
            System.out.println("The Value is " + value + ".");
        } else {
            System.out.println("Invalid");
        }
    }

    private static void lazyEvalPrintValue (int number, Supplier<String> supplier) {
        if (number >= 0) {
            System.out.println("The Value is " + supplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }

}
