package StackQueue.queue;

import java.util.*;

public class ReverseFirstKElementsOfQueue {
    public static Queue<Integer> modifyQueue(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();
        int size = queue.size();

        for(int i = 1; i <= k; i++) {
            stack.push(queue.remove());
        }

        for(int i = 1; i <= k; i++) {
            queue.add(stack.pop());
        }

        for(int i = 1; i <= size - k; i++) {
            queue.add(queue.remove());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        int k = 3;

        Queue<Integer> ans = modifyQueue(queue, k);
        System.out.println(ans);
    }
}
