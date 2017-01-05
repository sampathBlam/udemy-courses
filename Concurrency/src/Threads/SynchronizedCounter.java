package Threads;

/**
 * Created by skkumar on 1/5/2017.
 */
public class SynchronizedCounter {
    private int count = 0;

    // The Incrementer method is made synchronized so that only one thread will access it at any point of time.
    private synchronized void IncrementCounter() {
        count++;
    }

    public static void main(String args[]) {
        SynchronizedCounter counter = new SynchronizedCounter();
        counter.DoCount();
    }

    private void DoCount() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    IncrementCounter();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    IncrementCounter();
            }
        });

        thread1.start();
        thread2.start();

        try {
            // Wait for the two threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.print("Final count : " + count);

    }
}