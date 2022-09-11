package StackQueue.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueCollections {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        queue.add(10);
        queue.add(20);
        queue.add(30);
//        System.out.println(queue.peek()); // head of queue will be displayed
        queue.remove();
        System.out.println(queue);

    }
}
