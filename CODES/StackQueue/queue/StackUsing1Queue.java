package StackQueue.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing1Queue {
    Queue<Integer> queue = new LinkedList<>();

    public void push(int value) {
        queue.add(value);

        int size = queue.size();
        for(int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        if(queue.isEmpty()) return -1;
        return queue.remove();
    }

    public int top() {
        if(queue.isEmpty()) return -1;
        return queue.peek();
    }

    public static void main(String[] args) {
        StackUsing1Queue q = new StackUsing1Queue();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.pop());
        System.out.println(q.queue.peek());
    }
}
