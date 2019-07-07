package com.sky.java.preparation.JavaBasicsTill4.ThreadSynchronization.ProducerConsumer;

import java.util.Random;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Producer(message))).start();
        (new Thread(new Consumer(message))).start();
    }
}

class Message{
    private String message;
    private boolean empty = true;

    public synchronized  String read(){
        while(empty){
            try {
                wait();
            }catch (InterruptedException e){

            }
        }
        empty =true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message){
        while (!empty){
            try {
                wait();
            }catch (InterruptedException e){

            }
        }
        empty=false;
        this.message = message;
        notifyAll();
    }
}

class Producer implements Runnable{
    private  Message message;

    public Producer(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        String messages[]={
                "humpty dumpty sat on the wall",
                "humpty dumpty fall from the wall",
                "Hello King",
                "Hi Friends",
                "sdfsdfsdfsf"
        };

        Random random = new Random();

        for(int i=0;i<messages.length; i++){
            message.write(messages[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch(InterruptedException e){
                message.write("Finished");
            }
        }
    }
}
class Consumer implements Runnable{

    private  Message message;

    public Consumer(Message message){
        this.message = message;
    }
    @Override
    public void run() {
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equals("Finnished"); latestMessage=message.read()){
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){

            }
        }
    }
}
