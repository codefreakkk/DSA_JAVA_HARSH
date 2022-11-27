package StackQueue.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static boolean isOperand(String val) {
        if(val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")) {
            return false;
        }
        return true;
    }
    public static int getAnswer(String value, int operand1, int operand2) {
        if(value == "+") return operand1 + operand2;
        if(value == "-") return operand1 - operand2;
        if(value == "*") return operand1 * operand2;
        if(value == "/") return operand1 / operand2;
        return 0;
    }
    public static int evalRPN(String[] tokens) {
        int size = tokens.length;
        int ans = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < size; i++) {
            String val = tokens[i];

            if(isOperand(val)) {
                stack.push(Integer.parseInt(val));
            } else {
                if(!stack.isEmpty()) {
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();

                    ans = getAnswer(val, operand2, operand1);
                    stack.push(ans);
                }
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }
}
