package StackQueue.stack;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKDigits(String s, int k) {
        int size = s.length();
        if(size == k) return "0";

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < size; i++) {
            int value = s.charAt(i) - '0';
            while(!stack.isEmpty() && stack.peek() > value && k > 0) {
                stack.pop();
                k--;
            }
            if(!stack.isEmpty() || value != 0) stack.push(value);
        }

        // remove elements from stack if there are no peak elements
        while(!stack.isEmpty() && k > 0)  {
            k--;
            stack.pop();
        }
        if(stack.isEmpty()) return "0";


        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) ans.append(stack.pop());

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "1432219";
        int k = 3;

        System.out.println(removeKDigits(s, k));
    }
}
