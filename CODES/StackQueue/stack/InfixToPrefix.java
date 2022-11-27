package StackQueue.stack;

import java.util.Stack;

public class InfixToPrefix {
    public static int precedence(char ch) {
        if(ch == '^') return 3;
        if(ch == '/' || ch == '*') return 2;
        if(ch == '+' || ch == '-') return 1;
        return 0;
    }
    public static String reverseString(String s) {
        String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') reverse +=  ')';
            else if(s.charAt(i) == ')') reverse += '(';
            else reverse += s.charAt(i);
        }
        return reverse;
    }

    public static String infixToPrefix(String s) {
        Stack<Character> stack = new Stack<>();
        int size =s.length();
        String reverse = reverseString(s);
        String answer = "";

        for(int i = 0; i < size; i++) {
            char item = reverse.charAt(i);
            if(Character.isLetter(item)) answer += item;
            else if(item == '(') stack.push(item);
            else if(item == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    answer += stack.pop();
                }
                if(!stack.isEmpty()) stack.pop();
            }
            else {
                while(!stack.isEmpty() && precedence(item) <= precedence(stack.peek())) {
                        answer += stack.peek();
                        stack.pop();
                    }
                    stack.push(item);
                }
        }
        while(!stack.isEmpty()) {
            answer += stack.peek();
            stack.pop();
        }
        return reverseString(answer);
    }

    public static void main(String[] args) {
        String s ="(A+B)*C-D+F";
        System.out.println(infixToPrefix(s));
    }
}
