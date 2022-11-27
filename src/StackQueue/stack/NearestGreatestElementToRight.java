package StackQueue.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreatestElementToRight {
    public static long[] nextGreaterToRight(long[] nums, int n) {
        Stack<Long> stack = new Stack<>();
        stack.push((long)-1);
        long[] ans = new long[n];

        for(int i = n - 1; i >= 0; i--) {
            long element = (long) nums[i];

            while(stack.peek() != -1 && stack.peek() <= element) stack.pop();
            ans[i] = stack.peek();
            stack.push(element);
        }

        return ans;
    }

    public static void main(String[] args) {
        long[] nums = {100, 85, 60, 70, 60, 75, 85};
        long[] ans = nextGreaterToRight(nums, nums.length);
        System.out.println(Arrays.toString(ans));
    }
}
