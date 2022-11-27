package StackQueue.stack;

import java.util.*;

public class NearestGreaterElement1Leetcode {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;


        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        for(int i = size2 - 1; i >=0; i--) {
            int value = nums2[i];
            while(stack.peek() != -1 && stack.peek() <= value) stack.pop();
            map.put(value, stack.peek());
            stack.push(value);
        }

        for(int i = 0; i < size1; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] ans = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
}
