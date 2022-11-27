package StackQueue.stack;

import java.util.Stack;

public class MaxRectangle {
    public static int[] nextSmaller(int[] height, int size) {
        int[] ans = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = size - 1; i >= 0; i--) {
            int element = height[i];
            while(stack.peek() != -1 && height[stack.peek()] >= element) {
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public static int[] prevSmaller(int[] height, int size) {
        int[] ans = new int[size];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i < size; i++) {
            int element = height[i];
            while(stack.peek() != -1 && height[stack.peek()] >= element) {
                stack.pop();
            }
            ans[i] = stack.peek();
            stack.push(i);
        }

        return ans;
    }
    public static int getMaxRectangleInRow(int[] nums, int size) {
        int max = Integer.MIN_VALUE;

        int[] prev = prevSmaller(nums, size);
        int[] next = nextSmaller(nums, size);

        for(int i = 0; i < size; i++) {
            int length = nums[i];

            // if there is no smaller element in right side
            if(next[i] == -1) next[i] = size;

            int breadth = next[i] - prev[i] - 1;
            int area = length * breadth;

            max = Math.max(max, area);
        }

        return max;
    }
    public static int maxRectangle(int[][] nums, int n, int m) {
        int max = getMaxRectangleInRow(nums[0], m);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(nums[i][j] != 0) nums[i][j] = nums[i][j] + nums[i - 1][j];
                else nums[i][j] = 0;
            }
            max = Math.max(max, getMaxRectangleInRow(nums[i], m));
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 1, 1, 1, 1},{0, 1, 0, 0, 0}};
        System.out.println(maxRectangle(nums, nums.length, nums[0].length));
    }
}
