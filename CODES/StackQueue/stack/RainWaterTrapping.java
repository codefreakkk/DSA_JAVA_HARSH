package StackQueue.stack;

import java.util.*;

public class RainWaterTrapping {
    public static long trappingWater(int[] nums, int n) {
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        int left = 0, right = n - 1, ans = 0;

        for(int i = 0; i < n; i++) {
            if(nums[left] <= nums[right]) {
                if (leftMax < nums[left]) leftMax = nums[left];
                else ans += leftMax - nums[left];
                left++;
            } else {
                if(rightMax < nums[right]) rightMax = nums[right];
                else ans += rightMax - nums[right];
                right--;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {6, 9, 9};
        System.out.println(trappingWater(nums, nums.length));
    }
}
