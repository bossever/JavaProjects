package com.ayushman;

import static com.ayushman.ThreadColor.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE + "Hello from the Main thread.");

        //Creating an instance of "AnotherThread" ---> a user-defined class which extends Thread
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");      //sets the name of the thread
        anotherThread.start();

        /*
        Remember that we don't call the run() method, instead we call the start() method
        (which starts the thread), which, in turn, calls the run() method for us.

        If the run() method is called instead of the start() method, the
        method runs on the same thread instead of creating a new one.
        */


        //Using an anonymous class which extends Thread
        new Thread(() -> System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.")).start();


        //Using an anonymous class which is a subclass of another user-defined class (this user-defined class implements Runnable)
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run().");
                try {
                    anotherThread.join();           //this method can be overloaded with a parameter which sets "timeout" value in milliseconds
                    System.out.println(ANSI_RED + "AnotherThread terminated, or timed out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted.");
                }
            }
        });

        myRunnableThread.start();
//        anotherThread.interrupt();              //interrupts a thread which is under execution

        System.out.println(ANSI_PURPLE + "Hello again from the Main thread.");
    }
}
