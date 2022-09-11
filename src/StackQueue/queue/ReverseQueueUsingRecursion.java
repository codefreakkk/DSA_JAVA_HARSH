package StackQueue.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {
    public static void solve(Queue<Integer> queue, Queue<Integer> rev) {
        if(queue.isEmpty()) return;

        int removed = queue.remove();
        solve(queue, rev);
        rev.add(removed);
    }

    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Queue<Integer> rev = new LinkedList();
        solve(queue, rev);

        return rev;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(reverse(queue));
    }
}

