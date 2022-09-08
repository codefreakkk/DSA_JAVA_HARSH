package sliding_window;

import java.util.*;

public class PickToys {
    // similar problem of leetcode 904. fruit into basket

    public static int totalFruit(int[] nums) {
        if(nums.length == 1) return 1;
        int size = nums.length;
        int i = 0, j = 0, maxi = Integer.MIN_VALUE, k  = 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < size) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if(map.size() > k) {
                while(map.size() > k) {
                    map.put(nums[i], map.get(nums[i]) - 1);
                    if(map.get(nums[i]) == 0) map.remove(nums[i]);
                    i++;
                }
            }
            if(map.size() <= k) maxi = Math.max(maxi, j -  i + 1);
            j++;
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(totalFruit(nums));
    }
}
