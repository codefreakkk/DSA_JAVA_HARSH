package StackQueue;

import java.util.Stack;

public class InfixToPostfix {
    public static int precedence(char ch) {
        if(ch == '/' || ch == '*') return 2;
        if(ch == '+' || ch == '-') return 1;
        return 3;
    }

    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        int size = s.length();

        for(int i = 0; i < size; i++) {
            char item = s.charAt(i);
            if(Character.isLetter(item)) answer += item;
            else {
                if(!stack.isEmpty() && precedence(item) > precedence(stack.peek())) stack.push(item);
                else {
                    while(!stack.isEmpty() && precedence(item) <= precedence(stack.peek())) {
                        if(!stack.isEmpty()) answer += stack.pop();
                    }
                    stack.push(item);
                }
            }
        }
        if(stack.size() > 0) {
            while(stack.size() != 0) answer += stack.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "x+y*z";
        System.out.println(infixToPostfix(s));
    }
}
