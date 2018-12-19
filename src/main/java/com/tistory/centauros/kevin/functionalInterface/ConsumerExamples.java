package com.tistory.centauros.kevin.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Rene on 2018-12-18.
 * auth : Rene
 */
public class ConsumerExamples {

    public static void multiply(int number) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (Integer num : nums) {
            System.out.println(number + " * " + num +" = " +(num*number));
        }
    }

    public static void main(String[] args) {
        Consumer<String> greeting = s -> ConsumerExamples.multiply(Integer.parseInt(s));

        greeting.accept("9");
    }
}
