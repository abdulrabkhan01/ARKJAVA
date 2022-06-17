package com.ark.completablefuture;


import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.ark.Utlis.sleep;
import static com.ark.Utlis.submitTask;

//Example of completable future
public class CompletableFutureExamples {

    public static void main(String[] args) {
        example1();
        example2();
    }

    private static void example2() {
        CompletableFuture<String> output = getOutputUsingSupplyAsync();
        try {
            System.out.println(output.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<String> getOutputUsingSupplyAsync() {
        return CompletableFuture.supplyAsync(() -> new MyServiceAsync().doSomeHeavyStuff());
    }

    private static void example1() {
        Future<String> output = getOutput();
        try {
            System.out.println(output.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<String> getOutput() {
        CompletableFuture<String> futureOutput = new CompletableFuture<>();
        Callable<String> callable = () -> {
            String output = null;
            try {
                output = new MyServiceAsync().doSomeHeavyStuff();
                futureOutput.complete(output);

            } catch (Exception e) {
                futureOutput.completeExceptionally(e);
            }
            return output;
        };
        submitTask(callable);
        return futureOutput;
    }

}

class MyServiceAsync {

    public String doSomeHeavyStuff() {
        System.out.println("Starting heavy lifting.......");
        sleep(10000);
        System.out.println("Heavy lifting ends...........");
        return "Some Output";
    }
}
