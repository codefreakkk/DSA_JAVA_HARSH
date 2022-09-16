package StackQueue.stack;

import java.util.*;

public class NearestGreaterElement2 {

    public static int[] nextGreaterElements(int[] nums) {
        int size = nums.length;

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[size];
        Arrays.fill(ans, -1);

        for(int i = 0; i < size * 2; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % size]) {
                // pop the element from stack
                ans[stack.pop()] = nums[i % size];
            }
            if(i < size) stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] ans = nextGreaterElements(nums);

        System.out.println(Arrays.toString(ans));

    }
}
