package StackQueue.stack;

import java.util.*;

public class DeleteMiddleElementInStack {
    public static void solve(Stack<Integer> stack, int count, int size) {
        if(count == size / 2) {
            stack.pop();
            return;
        }

        int element = stack.pop();
        solve(stack, count + 1, size);
        stack.push(element);
    }

    public static void deleteMiddle(Stack<Integer> stack, int size) {
        int count = 0;
        if(stack.isEmpty()) return;
        solve(stack, count, size);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        deleteMiddle(stack, stack.size());
        System.out.println(stack);
    }
}
