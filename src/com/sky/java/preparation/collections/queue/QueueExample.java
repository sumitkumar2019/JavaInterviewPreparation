package com.sky.java.preparation.collections.queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String value1, String value2) {
        return Integer.compare(
                value1.length(),
                value2.length()
        );
    }
}
public class QueueExample {
    public static void main(String[] args) {
        Queue<String> stringQueue = new PriorityQueue<>();
        System.out.println(stringQueue.poll());
        stringQueue.offer("Apple");
        System.out.println(stringQueue);
        stringQueue.addAll(List.of("Ball", "Cat", "Dog"));
        System.out.println(stringQueue);
        System.out.println(stringQueue.poll());//Apple
        System.out.println(stringQueue);
        System.out.println(stringQueue.poll());//Ball
        System.out.println(stringQueue.poll());//Cat
        System.out.println(stringQueue.poll());//Dog
        System.out.println(stringQueue.poll());//null

        Queue<String> stringQueue2 = new PriorityQueue<>(new StringLengthComparator());
        stringQueue2.addAll(List.of("Zebra", "Monkey", "Cat"));
        System.out.println(stringQueue2.poll()); //Cat
        System.out.println(stringQueue2.poll()); //Zebra
        System.out.println(stringQueue2.poll()); //Monkey
        System.out.println(stringQueue2.poll()); //null

    }
}