package StackQueue.stack;

import java.util.*;

public class MaximumOfMinimumForEveryWindowSize {
    public static int[] nsl(int[] nums) {
        int size = nums.length;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int[] indexes = new int[size];

        for(int i = 0; i < size; i++) {
            while(stack.peek() != -1 && nums[stack.peek()] >= nums[i]) stack.pop();
            indexes[i] = stack.peek();
            stack.push(i);
        }

        return indexes;
    }

    public static int[] nsr(int[] nums) {
        int size = nums.length;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int[] indexes = new int[size];

        for(int i = size - 1; i >= 0; i--) {
            while(stack.peek() != -1 && nums[stack.peek()] >= nums[i]) stack.pop();
            indexes[i] = stack.peek();
            stack.push(i);
        }

        return indexes;

    }

    public static int[] maxOfMin(int[] nums, int n) {
        int[] ans = new int[n];

        int[] left = nsl(nums);
        int[] right = nsr(nums);

        for(int i = 0; i < n; i++) {
            if(right[i] == -1) right[i] = n;
            ans[right[i] - left[i] - 2] = Math.max(nums[i], ans[right[i] - left[i] - 2]);
        }

        for(int i = n - 2; i >= 0; i--) ans[i] = Math.max(ans[i + 1], ans[i]);

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,20,30,50,10,70,30};
        int[] ans = maxOfMin(nums, nums.length);

        System.out.println(Arrays.toString(ans));
    }
}
