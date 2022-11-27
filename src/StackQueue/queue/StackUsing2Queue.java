package StackQueue.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int value) {
        while(!q1.isEmpty()) q2.add(q1.remove());

        q1.add(value);
        while(!q2.isEmpty()) q1.add(q2.remove());
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        if(q1.isEmpty()) return -1;
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsing2Queue s = new StackUsing2Queue();
        s.push(10);
        s.push(20);
        System.out.println(s.top());
    }
}
