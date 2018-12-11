package com.tistory.centauros.ch1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Rene on 2018. 12. 11..
 * auth : Rene
 */
public class Ex1 implements Runnable {

    Log log = LogFactory.getLog("stdLogger");

    public void run() {
        int i = 0;
        for (int j = 0; j <= 1000; j++) {
            i += j;
        }
        log.debug("i :: " + i);
        System.out.println("i :: " + i);
    }

    public static void main(String[] args) {
        Ex1 ex1 = new Ex1();
        new Thread(ex1).start();
    }
}
