package StackQueue;

import java.util.*;

public class MultipleParenthesisMatching {
    public static boolean match(char poped, char exp) {
        if(poped == '{' && exp == '}') return true;
        if(poped == '(' && exp == ')') return true;
        if(poped == '[' && exp == ']') return true;
        return false;
    }
    public static boolean multipleParenthisisMatching(String s) {
        int size = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < size; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.push(s.charAt(i));
            else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if(stack.size() == 0) return false;
                char poped = stack.pop();
                if(!match(poped, s.charAt(i))) return false;
            }
        }

        if(stack.size() == 0) return true;
        return false;
    }


    public static void main(String[] args) {
        String s = "[{(0 + 0)]}";
        System.out.println(multipleParenthisisMatching(s));
    }
}
