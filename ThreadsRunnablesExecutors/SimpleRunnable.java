package ThreadsRunnablesExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
/**
 * Created by Joseph on 9/27/16.
 */

public class SimpleRunnable implements Runnable {

    //happy path - override run for implementing Runnable
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread id: " + Thread.currentThread().getName() + '\n');
            try {
                Thread.currentThread().sleep(100);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] params) {
        //happy path - create an executor and create some threads in the executor
        //then put the threads to sleep and output a message when they are finished sleeping.
        Executor anExecutor = Executors.newCachedThreadPool();
        for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
            SimpleRunnable aSillyRunnable = new SimpleRunnable();
            anExecutor.execute(aSillyRunnable);
        }
        try {
            Thread.sleep(5000);
            System.out.println("Done Sleeping\n");
            for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
                SimpleRunnable aSimpleRunnable = new SimpleRunnable();
                anExecutor.execute(aSimpleRunnable);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Nasty Path, pass a negative number into sleep
        try {
            Thread.sleep(-1);
            System.out.println("Did this happen?\n");
            for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
                SimpleRunnable aSimpleRunnable = new SimpleRunnable();
                anExecutor.execute(aSimpleRunnable);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //It gives us an illegal argument Exception, well have to be careful when we are calculating a value inside
        //the sleep parameter.

        //Nasty Path - What happens if I pass a char into sleep? Chars are just numbers in the ascii table right?
        try {
            Thread.sleep('T');
            System.out.println("Will it do something strange?");
            for (int threadCnt = 0; threadCnt < 3; threadCnt++) {
                SimpleRunnable aSimpleRunnable = new SimpleRunnable();
                anExecutor.execute(aSimpleRunnable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //It printed without a problem - so we need to be careful, it will work with a Char when we don't want it to, but
        // it will not work with a string and will error at compile.

        //Nasty Path - what if I have 10 tasks that I want to execute in parallel but only have 4 threads in the pool?
        ExecutorService smallPool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            smallPool.submit(new SimpleRunnable());
        }
    }
}
