package StackQueue.stack;

import java.util.*;

public class GetMinimumElementFromStack {
    static int minimum;
    static Stack<Integer> stack;

    public GetMinimumElementFromStack() {
        stack = new Stack<>();
        minimum = Integer.MIN_VALUE;
    }

    int getMin()
    {
        // Your code here
        if(stack.isEmpty()) {
            return -1;
        }
        return minimum;
    }

    int pop()
    {
        // check if stack empty
        if(stack.isEmpty()) return -1;

        int current = stack.peek();
        stack.pop();

        if(current > minimum) {
            return current;
        }

        else {
            int prevMin = minimum;

            // flag conversion
            int value = (2 * minimum) - current;
            minimum = value;

            // return prevmin because in original stack there is formula numbered stored not the original one
            return prevMin;
        }

    }

    void push(int x)
    {
        if(stack.isEmpty()) {
            stack.push(x);
            minimum = x;
        } else {
            if(x < minimum) {
                int value = (2 * x) - minimum;
                stack.push(value);
                minimum = x;
            }
            else stack.push(x);
        }
    }

    public static void main(String[] args) {

    }
}
