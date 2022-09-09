package StackQueue.stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    public static void reverse(Stack<Integer> stack, int element) {
        if(stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int removed = stack.pop();
        reverse(stack, element);
        stack.push(removed);
    }

    public static void solve(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int removed = stack.pop();
        solve(stack);
        reverse(stack, removed);
    }

    public static void reverseStack(Stack<Integer> stack) {
        solve(stack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
        System.out.println(stack);
    }
}
