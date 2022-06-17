package com.ark;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Simple class with utility methods
public class Utlis {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <V> Future<V> submitTask(Callable<V> task) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<V> output = executorService.submit(task);
        executorService.shutdown();
        return output;
    }
}
