package StackQueue.stack;

import java.util.*;

public class NextSmallerElement {
    public static void nextSmaller(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            int element = nums[i];
            while(stack.peek() >= element) stack.pop();
            ans[i] = stack.peek();
            stack.push(element);
        }

        for(int i = 0; i < n; i++) nums[i] = ans[i];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        int n = nums.length;
        nextSmaller(nums, n);
        System.out.println(Arrays.toString(nums));
    }
}
