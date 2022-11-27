package StackQueue.stack;

import java.util.Stack;

public class PostfixToInfix {
    public static boolean isOperand(char x)
    {
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }
    public static String postfixToInfix(String s) {
        Stack<String> stack = new Stack<>();
        int size = s.length();

        for(int i = 0; i < size; i++) {
            char item = s.charAt(i);
            if(isOperand(item)) stack.push(String.valueOf(item));
            else {
                if(!stack.isEmpty()) {
                    String first = stack.pop();
                    String second = stack.pop();
                    String finalString = second + item + first;
                    stack.push("(" + finalString + ")");
                }
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String s = "AB-DE+F*/";
        System.out.println(postfixToInfix(s));
    }
}
