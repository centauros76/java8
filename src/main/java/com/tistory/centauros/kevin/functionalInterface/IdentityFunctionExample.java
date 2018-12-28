package com.tistory.centauros.kevin.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Rene on 2018-12-27.
 * auth : Rene
 */
public class IdentityFunctionExample {

    public static void main(String[] args) {
        System.out.println(Math.abs(-2));
        System.out.println(Math.abs(2));
        System.out.println(Math.abs(Integer.MIN_VALUE));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(map(numbers, i -> i * 2));
        System.out.println(map(numbers, i -> i));
        System.out.println(map(numbers, Function.identity()));

    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for(T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }
}
