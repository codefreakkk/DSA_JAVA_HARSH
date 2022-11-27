package StackQueue.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
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
    public static int mha(int[] nums, int size) {
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

    public static int maxRectangle(char[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        // convert char matrix to int
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = (char) (mat[i][j] - '0');
            }
        }

        // mha function for finding max rectangle of each row
        int max = mha(matrix[0], m);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] != 0) matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
                else matrix[i][j] = 0;
            }

            max = Math.max(max, mha(matrix[i], m));
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maxRectangle(matrix));
    }
}
