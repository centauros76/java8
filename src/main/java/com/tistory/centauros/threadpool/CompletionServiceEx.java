package com.tistory.centauros.threadpool;

import java.util.concurrent.*;

public class CompletionServiceEx {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletionService completionService = new ExecutorCompletionService(executorService);

        System.out.println("처리 요청");

        for (int i=0; i<3; i++) {
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return null;
                }
            });
        }


    }
}
