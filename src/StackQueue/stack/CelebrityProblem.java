package StackQueue.stack;

import java.util.*;

public class CelebrityProblem {
    public static int celebrity(int[][] nums, int n) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) stack.push(i);

        while(stack.size() > 1) {
            int person1 = stack.pop();
            int person2 = stack.pop();

            if(nums[person1][person2] == 1) stack.push(person2);
            else stack.push(person1);
        }

        int candidate = stack.pop();

        // check row and column
        int rowCount = 0;
        for(int i = 0; i < n; i++) {
            if(nums[candidate][i] == 0) rowCount++;
        }

        if(rowCount != n) return -1;

        int colCount = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i][candidate] == 1) colCount++;
        }

        if(colCount != n - 1) return -1;
        return candidate;
    }

    public static void main(String[] args) {
        int[][] nums = {{0,1},
                {1, 0}};
        int n = nums.length;

        System.out.println(celebrity(nums, n));
    }
}
