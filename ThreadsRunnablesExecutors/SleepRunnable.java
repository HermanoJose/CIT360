package ThreadsRunnablesExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Joseph on 10/4/16.
 */
public class SleepRunnable implements Runnable {

    public void run() {
        System.out.println("You will see another thread every three seconds 10 times");
        int count = 0;
        count++;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] params) {

        ExecutorService anExecutor = Executors.newFixedThreadPool(1);

        SleepRunnable aSleeper = new SleepRunnable();

        for (int i = 0; i < 10; i++) {
            anExecutor.execute(aSleeper);
         }

        System.out.println("I think I get it.");



        //send null to a thread and then tell it to start or null to an execute
        //race condition and crosslock
        //sharing data across threads
        /*for (int threadCnt = 0; threadCnt < 1; threadCnt++) {
            SleepThread aSleepThread = new SleepThread();
            anExecutor.execute(aSleepThread);
        }
        try {
            Thread.sleep(3000);
            System.out.println("3 second nap!");
            for (int threadCnt = 0; threadCnt < 1; threadCnt++) {
                SleepThread aSleepThread = new SleepThread();
                anExecutor.execute(aSleepThread);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/



    }

}
