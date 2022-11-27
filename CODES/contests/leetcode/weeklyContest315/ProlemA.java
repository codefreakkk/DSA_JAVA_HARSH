package contests.leetcode.weeklyContest315;

import java.util.*;

public class ProlemA {
    public static int findMaxK(int[] nums) {
        int size = nums.length;
        if(size == 1) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++) {
            if(nums[i] < 0) map.put(Math.abs(nums[i]), nums[i]);
        }

        // check for potential answer
        int ans = -1;
        for(int i = 0; i < size; i++) {
            if(nums[i] > 0) {
                if(map.containsKey(nums[i])) {
                    if(nums[i] + map.get(nums[i]) == 0) {
                        ans = Math.max(ans, nums[i]);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-49,8,19,-39,37,22,-39,4,37,8,20,-2,-4,-5,14,-14,
                -27,24,30,3,-12,19,22,28,-3,-6,6,22,37,27,16,27,-6,-49,31,29};
        System.out.println(findMaxK(nums));
    }
}
