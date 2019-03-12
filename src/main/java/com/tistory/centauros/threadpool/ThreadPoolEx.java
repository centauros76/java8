package com.tistory.centauros.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolEx {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i=0; i<10; i++) {
            executorService.submit(new RunnableAction());
//            Future future = executorService.submit(new CallableAction());
//            System.out.println("This is main print :: " + future.get());
        }
        executorService.shutdown();
    }
}
