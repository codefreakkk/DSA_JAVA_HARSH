package StackQueue;

import java.util.*;

public class ParenthesisMatching {
    public static boolean parenthesisMatching(String s) {
        Stack<Character> stack = new Stack<>();
        int size = s.length();

        for(int i = 0; i < size; i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            }
            if(s.charAt(i) == ')'){
                if(stack.size() == 0) return false;
                stack.pop();
            }
        }
        if(stack.size() == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "(((2 * (2 - 2)) + (3*2))";
        System.out.println(parenthesisMatching(s));
    }
}
