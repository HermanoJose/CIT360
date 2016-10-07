package ThreadsRunnablesExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Joseph on 10/6/16.
 */
public class CrossLock {
    public static Object cross1 = new Object();
    public static Object cross2 = new Object();

    public static void main (String[] params) {
        ThreadLock1 thread1 = new ThreadLock1();
        ThreadLock2 thread2 = new ThreadLock2();
        thread1.start();
        thread2.start();

    }

    private static class ThreadLock1 extends Thread {
        public void run() {
            synchronized (cross1) {
                System.out.println("I need the screwdriver first!");
                try {
                    Thread.sleep(1000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("I need the hammer but the other thread isn't done with it!");
                synchronized (cross2) {
                    System.out.println("Now I have the hammer!");
                }
            }
        }
    }

    private static class ThreadLock2 extends Thread {
        public void run() {
            synchronized (cross2) {
                System.out.println("I need the hammer first!");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("I need the screwdriver but the other thread has it still!");
                synchronized (cross1) {
                    System.out.println("Now I have the screwdriver!");
                }
            }
        }
    }
    //Everytihng gets locked up because they are both waiting for each other! If I had them both do the first
    // cross object then it would have been okay because they could both use one, then give them both to
    // the other, however, right now they areholding the object the other needs while requested the next!
    // careful!

}
