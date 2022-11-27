package StackQueue.stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int[] nextSmaller(int[] height) {
        int size = height.length;
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

    public static int[] prevSmaller(int[] height) {
        int size = height.length;
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

    public static int largestRectangleArea(int[] height) {
        int size = height.length;
        int max = Integer.MIN_VALUE;

        int[] next = nextSmaller(height);
        int[] prev = prevSmaller(height);

        for(int i = 0; i < size; i++) {
            int length = height[i];

            // if there is no next smaller element
            if(next[i] == -1) next[i] = size;

            int breadth = next[i] - prev[i] - 1;
            int area = length * breadth;

            max = Math.max(max, area);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(Arrays.toString(prevSmaller(nums)));
        System.out.println(Arrays.toString(nextSmaller(nums)));
        System.out.println(largestRectangleArea(nums));
    }
}
