package com.tistory.centauros.threadpool;

import java.util.Arrays;
import java.util.List;

public class RunnableAction implements Runnable{

    List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Override
    public void run() {
        int sum = number.stream().mapToInt(Integer::intValue).sum();
        System.out.println("RunnableAction sum :: " + sum + ", ThreadName :: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
