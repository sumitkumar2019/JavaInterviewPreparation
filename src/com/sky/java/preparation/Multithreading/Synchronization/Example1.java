    package com.sky.java.preparation.Multithreading.Synchronization;

public class Example1 {
    public static void main(String[] args) {
        //CountDown countDown1 = new CountDown();
        //CountDown countDown2 = new CountDown();
        //CountDownThread t1 = new CountDownThread(countDown1);
        CountDown countDown = new CountDown();
        CountDownThread t1 = new CountDownThread(countDown);
        t1.setName("Thread-1");
        t1.start();
        //CountDownThread t2 = new CountDownThread(countDown2);
        CountDownThread t2 = new CountDownThread(countDown);
        t2.setName("Thread-2");
        t2.start();
    }
}

//Primitive types don't have intrinsic lock (Monitor)- only Every Object has intrinsic lock (Monitor)
class CountDown{
    private int i;
    // Synchronized block for this object will work even though it is not used other than the block - because object is in heap
    //Object o = new Object();
    //public synchronized void onCountDown(){ - Synchronizing a method
        public void onCountDown(){
        String color="";
        // -- on Local variable intrinsic lock or Monitor can not be acquired
        // - so we will see the same result as it was before synchronization
        // - because local variables stays in stack instead of heap
        // String color="";
        switch (Thread.currentThread().getName()){
            case "Thread-1":
                color=ThreadColor.ANSI_CYAN; break;
            case "Thread-2":
                color=ThreadColor.ANSI_MAGENTA; break;
            case "Thread-3":
                color=ThreadColor.ANSI_GREEN; break;
            case "Thread-4":
                color=ThreadColor.ANSI_BLACK; break;
            case "Thread-5":
                color=ThreadColor.ANSI_RED; break;
            case "Thread-6":
                color=ThreadColor.ANSI_YELLOW; break;
            case "Thread-7":
                color=ThreadColor.ANSI_WHITE; break;
        }
        //synchronized (new Object()){ - synchronization will not work - because local object and in the local stack not in heap
        //synchronized (color){ - synchronization will not work - because local object and in the local stack not in heap
          synchronized (this){ //- synchronization will work - because this object and in the in heap
            for(i=10; i>0; i--){
                System.out.println( color + Thread.currentThread().getName()+" : i ="+ i);
            }
        }

    }
}

class CountDownThread extends Thread{
    private CountDown threadCountDown;

    public CountDownThread(CountDown countDown){
        threadCountDown = countDown;
    }

    @Override
    public void run() {
        threadCountDown.onCountDown();
    }
}
