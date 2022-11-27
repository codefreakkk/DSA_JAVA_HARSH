package StackQueue.queue;

import java.util.*;

public class ReverseQueueUsingStack {

    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int size = queue.size();

        for(int i = 0; i < size; i++) stack.push(queue.remove());
        for(int i = 0; i < size; i++) queue.add(stack.pop());

        return queue;

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(reverse(queue));
    }
}
