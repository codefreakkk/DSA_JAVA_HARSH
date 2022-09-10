package StackQueue.stack;

import java.util.*;

public class MaximumRectangularAreaInHistogram {
    public static int[] nearestSmallerRightIndexes(int[] nums) {

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

    public static int[] nearestSmallerLeftIndexes(int[] nums) {

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

    public static int largestRectangularArea(int[] height) {

        int[] right = nearestSmallerRightIndexes(height);
        int[] left = nearestSmallerLeftIndexes(height);

        int size = height.length, max = Integer.MIN_VALUE;

        for(int i = 0; i < size; i++) {
            int length = height[i];

            // nearest right element is -1
            if(right[i] == -1) right[i] = size;

            int ans = length * (right[i] - left[i] - 1);
            max = Math.max(max, ans);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4};
        System.out.println(largestRectangularArea(nums));
    }

}
