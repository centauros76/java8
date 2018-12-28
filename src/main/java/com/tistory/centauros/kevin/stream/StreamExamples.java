package com.tistory.centauros.kevin.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Rene on 2018-12-27.
 * auth : Rene
 */
public class StreamExamples {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultList = new ArrayList<>();
        Integer result = null;

        for(Integer number : numbers) {
            if (number > 3 && number < 9) {
                resultList.add(number);
                Integer newNumber = number * 2;
                if (newNumber > 10) {
                    result = newNumber;
                    break;
                }
            }
        }
        System.out.println("resultList :: " + resultList);
        System.out.println("result :: " + result);

//        System.out.println("Function Result :: " +
//                numbers.stream()
//                        .filter(i -> {
//                            System.out.println(i + " > 3 ? ");
//                            return i > 3;
//                        })
//                        .filter(i -> {
//                            System.out.println(i + " < 9 ? ");
//                            return i < 9;
//                        })
//                        .map(i -> {
//                            System.out.println(i + " * 2 = ");
//                            return i * 2;
//                        })
//                        .filter(i -> {
//                            System.out.println(i + " > 10 ? ");
//                            return i > 10;
//                        })
//                        .findFirst()
//        );

        System.out.println("Function Result :: " +
            numbers.stream()
                   .filter(i -> i > 3)
                   .filter(i -> i < 9)
                   .map(i -> i*2)
                   .filter(i -> i > 10)
                   .findFirst()
        );
    }


}
