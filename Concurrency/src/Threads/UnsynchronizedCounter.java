package Threads;

/**
 * Created by skkumar on 1/5/2017.
 */
public class UnsynchronizedCounter {
    private int count = 0;

    public static void main(String args[]){
        UnsynchronizedCounter counter = new UnsynchronizedCounter();
        counter.DoCount();
    }

    private void DoCount(){

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i < 10000 ; i++)
                    count++;
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i < 10000 ; i++)
                    count++;
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


        System.out.print("Final count : "+count);

    }
}
