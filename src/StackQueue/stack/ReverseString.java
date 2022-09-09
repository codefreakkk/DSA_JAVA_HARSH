package StackQueue.stack;

import java.util.Stack;

public class ReverseString {
    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        String answer = "";

        for(int i = 0; i < s.length(); i++) stack.push(s.charAt(i));
        while(stack.size() != 0) answer += stack.pop();

        return answer;
    }

    public static void main(String[] args) {
        String s = "harsh";
        System.out.println(reverseString(s));
    }
}
