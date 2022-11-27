package StackQueue.queue;

import java.util.Stack;

public class QueueUsing1Stack {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int value) {
        input.push(value);
    }

    public int pop() {
        if(!output.isEmpty()) return output.pop();
        else {
            while(!input.isEmpty()) output.push(input.pop());
            return output.pop();
        }
    }

    public boolean empty() {
        if(input.isEmpty() && output.isEmpty()) return true;
        return false;
    }

    public int peek() {
        if(!output.isEmpty()) return output.peek();
        else {
            while(!input.isEmpty()) output.push(input.pop());
            return output.peek();
        }
    }

    public static void main(String[] args) {
        QueueUsing1Stack q = new QueueUsing1Stack();
        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.pop());
        System.out.println(q.peek());
    }
}
