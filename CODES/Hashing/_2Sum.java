package Hashing;

import java.util.*;

public class _2Sum {
    // this is brute force approach TC o(N ^ 2)
    public static int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        int size = nums.length;

        for(int i = 0; i < size; i++) {
            int newTarget = target - nums[i];

            for(int j = i + 1; j < size; j++) {
                if(nums[j] == newTarget) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }

        return ans;
    }

    // better approach using hashing TC : o(N), SC : o(N)
    public static int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < size; i++) {
            int newTarget = target - nums[i];
            if(map.containsKey(newTarget)) {
                ans[0] = map.get(newTarget);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
