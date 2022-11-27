package StackQueue.stack;

import java.util.*;

public class SortStack {
    public static void sort(Stack<Integer> stack, int element) {
        if(stack.isEmpty()) {
            stack.push(element);
            return;
        }
        if(stack.peek() <= element) {
            stack.push(element);
            return;
        }

        int removed = stack.pop();
        sort(stack, element);
        stack.push(removed);
    }

    public static void solve(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int removed = stack.pop();
        solve(stack);

        // sort the stack
        sort(stack, removed);
    }

    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        solve(stack);
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(2);
        stack.push(32);
        stack.push(3);
        stack.push(41);
        Stack<Integer> ans = sortStack(stack);
        System.out.println(ans.peek());
    }
}
