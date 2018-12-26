package com.tistory.centauros;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.List;

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
        System.out.println(numbers.contains(Integer.valueOf(2)));
    }
}
