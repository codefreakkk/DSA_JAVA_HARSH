package StackQueue.stack;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean match(char item, char removed) {
        if(item == '(' && removed == ')') return true;
        if(item == '[' && removed == ']') return true;
        if(item == '{' && removed == '}') return true;
        return false;
    }

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        int size = str.length();

        for(int i = 0; i < size; i++) {
            char item = str.charAt(i);
            if(item == '(' || item == '[' || item == '{') stack.push(item);
            else {
                if(stack.isEmpty()) return false;
                char removed = stack.pop();
                if(!match(removed, item)) return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }
}
