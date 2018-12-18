package com.tistory.centauros.kevin.functionalInterface;

import java.util.function.Function;

/**
 * Created by Rene on 2018-12-18.
 * auth : Rene
 */
public class FunctionExamples {

    public static void main(String[] args) {
        Function <String, Integer> toInt = value -> Integer.parseInt(value);
        Function <Integer, String> toString = value -> Integer.toString(value);

        System.out.println(toInt.apply("5"));
        System.out.println(toString.apply(10));

        Function <String, String> identity = s -> s;
        Function <Integer, Integer> identity1 = Function.identity();

        System.out.println(identity.apply("200"));
        System.out.println(identity1.apply(399));
    }
}
