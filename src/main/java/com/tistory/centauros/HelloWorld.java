package com.tistory.centauros;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Rene on 2018. 12. 11..
 * auth : Rene
 */
public class HelloWorld {

    public static void main(String[] args) {
        Log log = LogFactory.getLog("stdLogger");
        log.debug("Hello World");
        System.out.println("Hello World");

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,4,3,2,3,4,5,6,6,2);
        List<Integer> distinctNumbers = (ArrayList)numbers.stream().distinct().collect(Collectors.toList());

        for (Integer integer : distinctNumbers) {
            System.out.println(integer + " count :: " + Collections.frequency(numbers, integer));
        }
    }
}
