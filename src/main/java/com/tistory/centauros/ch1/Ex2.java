package com.tistory.centauros.ch1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Rene on 2018. 12. 11..
 * auth : Rene
 */
public class Ex2 implements Comparator<String> {

    Log log = LogFactory.getLog("stdLogger");

    public int compare(String first, String second) {
        int compare;

        compare = Integer.compare(first.length(), second.length());
        log.debug("first :: " + first);
        log.debug("second :: " + second);
        log.debug("compare :: " + compare);

        return compare;
    }

    public static void main(String[] args) {

        String[] strings = {"hello world", "happy", "who am i"};
        Ex2 ex2 = new Ex2();

        Arrays.sort(strings, ex2);

        for (String string : strings) {
            System.out.println("string :: " + string);

        }
    }
}
