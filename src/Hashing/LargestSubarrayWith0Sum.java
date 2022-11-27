package Hashing;

import java.util.*;

public class LargestSubarrayWith0Sum {
    public static int largestSubarrayWithSumZero(int[] nums, int size) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <size; i++) {
            sum += nums[i];
            if(sum == 0) maxi = i + 1;
            else {
                if(map.get(sum) != null) maxi = Integer.max(maxi, i - map.get(sum));
                else map.put(sum, i);
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        System.out.println(largestSubarrayWithSumZero(nums, nums.length));
    }
}


