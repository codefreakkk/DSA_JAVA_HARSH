package StackQueue.stack;

import java.util.Stack;

public class RedundantBracketOrNot {
    public static boolean isOperator(char item) {
        if(item == '+' || item == '*' || item == '-' || item == '/') return true;
        else return false;
    }

    public static int checkRedundancy(String str) {
        Stack<Character> stack = new Stack<>();
        int size = str.length();

        for(int i = 0; i < size; i++) {
            char item = str.charAt(i);
            if(item == '(' || isOperator(item)) stack.push(item);
            else {
                if(item == ')') {
                    if(!isOperator(stack.peek())) return 1;
                    while(!stack.isEmpty() && isOperator(stack.peek())) stack.pop();
                    if(!stack.isEmpty()) stack.pop();
                }
            }
        }

        if(stack.isEmpty()) return 0;
        return 1;
    }

    public static void main(String[] args) {
        String str = "(a+v)";
        System.out.println(checkRedundancy(str) == 1 ? "yes" : "no");
    }
}
