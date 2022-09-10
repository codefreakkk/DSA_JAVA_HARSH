package StackQueue.stack;

import java.util.*;

public class NearestSmallerElementToLeft {
    public static List<Integer> nextSmallestOnRight(int[] nums, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int element = nums[i];

            while(stack.peek() >= element) stack.pop();

            list.add(stack.peek());
            stack.push(element);
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 4, 10, 2, 5};
        List<Integer> ans = nextSmallestOnRight(nums, nums.length);
        System.out.println(ans);
    }
}
