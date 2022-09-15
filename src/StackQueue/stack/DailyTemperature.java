package StackQueue.stack;

import java.util.*;

public class DailyTemperature {
    public static int[] ngr(int[] nums) {
        int size = nums.length;

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[size];

        stack.push(-1);

        for(int i = size - 1; i >= 0; i--) {
            while(stack.peek() != -1 && nums[stack.peek()] <= nums[i]) stack.pop();

            ans[i] = stack.peek();
            stack.push(i);
        }

        return ans;
    }

    public static int[] dailyTemperature(int[] nums) {
        int size = nums.length;
        int[] ans = new int[size];

        int[] index = ngr(nums);

        for(int i = 0; i < size; i++) {
            if(index[i] == -1) ans[i] = 0;
            else ans[i] = index[i] - i;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {30,60,90};
        int[] ans = dailyTemperature(nums);

        System.out.println(Arrays.toString(ans));
    }
}
