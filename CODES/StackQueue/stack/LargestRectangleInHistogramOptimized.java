package StackQueue.stack;

import java.util.Stack;

public class LargestRectangleInHistogramOptimized {
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int size = height.length, max = Integer.MIN_VALUE;

        for(int i = 0; i <= size; i++) {

            while(!stack.isEmpty() && (i == size || height[stack.peek()] >= height[i])) {
                int length = height[stack.peek()];
                stack.pop();

                int width;
                if(stack.isEmpty()) width = i;
                else width = i - stack.peek() - 1;

                max = Math.max(max, length * width);
            }
            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(nums));
    }
}
