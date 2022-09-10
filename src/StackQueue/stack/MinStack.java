package StackQueue.stack;

import java.util.Stack;

public class MinStack
{
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }

    int getMin()
    {
        // Your code here
        if(stack.isEmpty()) return -1;
        return min;
    }

    int pop()
    {
        // check if stack empty
        if(stack.isEmpty()) return -1;

        int current = stack.peek();
        stack.pop();

        if(current > min) return current;
        else {
            int previousMin = min;
            min = (2 * min) - current;

            // return previous min if there is any flag present in the stack
            return previousMin;
        }


    }

    void push(int x)
    {
        if(stack.isEmpty()) {
            stack.push(x);
            min = x;
        }

        else {
            if(x < min) {
                stack.push((2 * x) - min);
                min = x;
            }

            else stack.push(x);
        }
    }

    public static void main(String[] args) {

    }
}

