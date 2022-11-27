package StackQueue.stack;

import java.util.Stack;

public class InsertAnElementAtBottom {
    public static void solve(Stack<Integer> stack, int count, int element, int size) {
        if(count == size) {
            stack.push(element);
            return;
        }

        int removed = stack.pop();
        solve(stack, count + 1, element, size);
        stack.push(removed);
    }

    public static Stack<Integer> pushAtBottom(Stack<Integer> stack, int x) {
        int size = stack.size();
        int count = 0;
        solve(stack, count, x, size);
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(1);
        stack.push(4);
        stack.push(5);
        int x = 9;
        Stack<Integer> ans = pushAtBottom(stack, x);
        System.out.println(ans);
    }
}
