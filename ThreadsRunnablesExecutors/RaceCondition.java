package ThreadsRunnablesExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Joseph on 10/4/16.
 */
public class RaceCondition implements Runnable {
    public void run() {
        this.add(1);
        System.out.println(Thread.currentThread().getName() + " " + this.count);
    }

    long count = 0;

    public void add (long value) {
        this.count += value;
    }

    public static void main (String[] params) {
        Executor anExecutor = Executors.newFixedThreadPool(5);
        RaceCondition aRunnable = new RaceCondition();

        for (int threadCnt = 0; threadCnt < 100; threadCnt++) {
            anExecutor.execute(aRunnable);
        }


        //Executor Nasty Path - send null to execute, what will it do?
        try {
            anExecutor.execute(null);
        } catch (Exception e){
            e.printStackTrace();
        }
        //Errors out

        //Thread Nasty path - send null to Thread.start(), what will it do?

        try {
            new Thread().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //I sent a null to it and it just created a new thread that didn't do anything. Could be bad because there are
        //going to be extra threads we don't need in the backgrounds


    }
}
