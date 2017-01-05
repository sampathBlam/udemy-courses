package Threads;

/**
 * Created by skkumar on 1/5/2017.
 */

class InterruptableThread extends Thread {

    @Override
    public void run() {
        super.run();
        while(true){
            if(this.isInterrupted()){
                System.out.println("I am interrupted!");
                break;
            }
            try {
                // Mostly this thread is interrupted when sleeping.
                // Probably when the work done by the thread is more, it might get interrupted during that time and not during sleep.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("I am interrupted while sleeping !!");
                e.printStackTrace();
            }
            System.out.println("I am running!!");
        }
    }
}

public class Interrupter {
    public static void main(String args[]){
        InterruptableThread thread = new InterruptableThread();
        System.out.println("Starting interruptable thread");
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupting interruptable thread");
        thread.interrupt();
    }
}
