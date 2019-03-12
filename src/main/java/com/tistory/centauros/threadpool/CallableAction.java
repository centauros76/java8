package com.tistory.centauros.threadpool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableAction implements Callable {

    List<Integer> number = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);

    @Override
    public Object call() throws Exception {
        int sum = number.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Callable Action !! sum :: " + sum + ", ThreadName :: " + Thread.currentThread().getName());
        Thread.sleep(1000);
        return sum;
    }
}
