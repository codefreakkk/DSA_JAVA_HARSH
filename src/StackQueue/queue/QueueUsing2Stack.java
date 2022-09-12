package StackQueue.queue;

import java.util.Stack;

public class QueueUsing2Stack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int value) {
        s1.push(value);
    }

    public int dequeue() {
        while(!s1.isEmpty()) s2.push(s1.pop());

        int removed = s2.pop();
	    while(!s2.isEmpty()) s1.push(s2.pop());

        return removed;
    }

    public static void main(String[] args) {
        QueueUsing2Stack queue = new QueueUsing2Stack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
