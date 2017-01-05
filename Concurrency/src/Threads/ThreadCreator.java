/**
 * Created by skkumar on 1/3/2017.
 */


package Threads;

class ThreadRunner extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i=1 ; i <= 10 ; i++){
            System.out.println("hello "+i+" from "+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class RunnableRunner implements Runnable{

    @Override
    public void run() {
        for (int i=1 ; i <= 10 ; i++){
            System.out.println("hello "+i+" from "+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadCreator {

    public static void main(String args[]){

        System.out.println("Hello World of Threads!");

        // Thread created by extending Thread class
        ThreadRunner threadRunner = new ThreadRunner();
        threadRunner.start();

        // Thread created by implementing Runnable Interface.
        RunnableRunner runnableRunner = new RunnableRunner();
        Thread runnableThread = new Thread(runnableRunner);
        runnableThread.start();

        // Thread created with anonymous runnable.
        Thread anonymousThread = new Thread(new Runnable(){

            @Override
            public void run() {
                for (int i=1 ; i <= 10 ; i++){
                    System.out.println("hello "+i+" from "+Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        anonymousThread.start();

        // Main thread
        for (int i=1 ; i <= 10 ; i++){
            System.out.println("hello "+i+" from "+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
