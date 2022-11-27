package StackQueue.stack;

import java.util.*;

public class NearestGreatestElementToLeft {
    public static int[] nextGreatestElementToLeft(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int element = nums[i];
            while(stack.peek() != -1 && stack.peek() <= element) stack.pop();
            ans[i] = stack.peek();
            stack.push(element);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100, 80, 60, 70, 60, 75, 85};
        int[] ans = nextGreatestElementToLeft(nums, nums.length);
        System.out.println(Arrays.toString(ans));
    }
}
