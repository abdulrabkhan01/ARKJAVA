package com.ark.completablefuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.ark.Utlis.*;

public class FutureExample {
    public static void main(String[] args) {
        Callable<String> callable = () -> {
            return new MyService().doSomeHeavyStuff();
        };
        Future<String> delayedOutput = submitTask(callable);
        System.out.println("I have just submitted some heavy lifting task, I am not blocked now, it is done by separate thread");
        //Lets check the status of the above heavy lifting task
        System.out.println("Is heavy lifting task completed? " + delayedOutput.isDone());
        //Now I am going to call get--remember it is a blocking call
        System.out.println("Going to wait for the result");
        try {
            System.out.println(delayedOutput.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Done processing with the heavy lifting :)");

    }
}

class MyService {
    public String doSomeHeavyStuff() {
        System.out.println("Starting heavy lifting.......");
        sleep(10000);
        System.out.println("Heavy lifting ends...........");
        return "Some Output";
    }
}