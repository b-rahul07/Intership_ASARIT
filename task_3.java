// File: ExceptionHandlingMultithread.java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread Class: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable Interface: " + i);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                System.out.println("Runnable interrupted: " + e.getMessage());
            }
        }
    }
}

public class ExceptionHandlingMultithread {
    public static void main(String[] args) {
        try {
            System.out.println("Main Thread Started");

            // Using Thread Class
            MyThread t1 = new MyThread();

            // Using Runnable Interface
            Thread t2 = new Thread(new MyRunnable());

            t1.start();
            t2.start();

            // Intentionally cause an exception
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // Will cause ArrayIndexOutOfBoundsException

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }

        System.out.println("Main Thread Finished");
    }
}
