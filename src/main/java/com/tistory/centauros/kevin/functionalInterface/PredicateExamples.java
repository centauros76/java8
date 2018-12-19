package com.tistory.centauros.kevin.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Rene on 2018-12-18.
 * auth : Rene
 */
public class PredicateExamples {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
        List<Integer> result = new ArrayList<>();

        Predicate<Integer> isPositiveNum = num -> num > 0;
        for (Integer num : numbers) {
            if (isPositiveNum.test(num)) {
                result.add(num);
            }
        }
        System.out.println("isPositiveNum :: " + result);


        result.clear();
        Predicate<Integer> lessThan3 = num -> num < 3;
        for (Integer num : numbers) {
            if (lessThan3.test(num)) {
                result.add(num);
            }
        }
        System.out.println("lessThan3 :: " + result);


        System.out.println("isPositiveNum :: " + filter(numbers, isPositiveNum));
        System.out.println("lessThan3 :: " + filter(numbers, lessThan3));
        System.out.println("isNegativeNum :: " + filter(numbers, num -> num < 0));

    }

    private static <T> List<T> filter (List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T input : list) {
            if (filter.test(input)) {
                result.add(input);
            }
        }
        return result;
    }

}
