package com.tistory.centauros;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Rene on 2018. 12. 11..
 * auth : Rene
 */
public class HelloWorld {

    public static void main(String[] args) {
        Log log = LogFactory.getLog("stdLogger");
        log.debug("Hello World");
        System.out.println("Hello World");
    }
}
