package com.tistory.centauros.ch1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Rene on 2018. 12. 11..
 * auth : Rene
 */
public class Ex2_1 {

    public static void main(String[] args) {

        String[] strings = {"hello world", "happy", "who am i"};

//        Comparator<String> comp =
//                (first, second) -> Integer.compare(first.length(), second.length());

        Arrays.sort(strings, (first, second) -> Integer.compare(first.length(), second.length()));

        for (String string : strings) {
            System.out.println("string :: " + string);

        }
    }
}
