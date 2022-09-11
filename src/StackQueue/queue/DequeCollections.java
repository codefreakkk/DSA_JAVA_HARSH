package StackQueue.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeCollections {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(10);
        deque.addFirst(20);

        deque.addLast(30);
        deque.addLast(40);

        // removes first element
        deque.removeFirst();

        // removes last element
        deque.removeLast();

        System.out.println(deque);
    }
}
