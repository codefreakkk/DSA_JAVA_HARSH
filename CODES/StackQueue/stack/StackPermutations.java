package StackQueue.stack;

import java.util.Stack;

public class StackPermutations {
    public static int isStackPermutation(int n, int[] ip, int[] op) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for(int i  = 0; i < n; i++) {
            int element = ip[i];
            stack.push(element);

            // pop element if peek and index values are equal
            while(!stack.isEmpty() && stack.peek() == op[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.size() > 0 ? 0 : 1;
    }


    public static void main(String[] args) {
        int[] ip = {1,2,3};
        int[] op = {3, 1, 2};

        System.out.println(isStackPermutation(ip.length, ip, op));
    }
}
