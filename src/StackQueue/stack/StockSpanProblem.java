package StackQueue.stack;

import java.util.*;

public class StockSpanProblem {
    public static int[] calculateSpan(int[] prices, int size) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] indexes = new int[size];

        // store greatest element index from left
        for(int i = 0; i < size; i++) {
            while(stack.peek() != -1 && prices[stack.peek()] <= prices[i]) stack.pop();
            indexes[i] = stack.peek();
            stack.push(i);
        }

        int[] ans = new int[size];
        for(int i = 0; i < size; i++) {
            ans[i] = i - indexes[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, 4, 5, 90, 120, 80};
        int[] ans = calculateSpan(nums, nums.length);
        System.out.println(Arrays.toString(ans));
    }
}
