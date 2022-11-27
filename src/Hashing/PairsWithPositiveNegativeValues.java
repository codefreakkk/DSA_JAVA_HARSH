package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PairsWithPositiveNegativeValues {
    public static long[] positiveNegativePairs(long[] nums, long n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int element = (int) nums[i];
            if(map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            }
            else {
                if(element > 0) map.put(element, 1);
            }
        }

        Arrays.sort(nums);
        int index = 0;
        for(int i = (int) n - 1; i >= 0; i--) {
            if(nums[i] < 0) {
                int data = (int) Math.abs(nums[i]);
                if(map.containsKey(data) && map.get(data) > 0) {
                    ans.add((int)nums[i]);
                    ans.add(data); // make negative number positive
                    map.put(data, map.get(data) - 1);
                }
            }
        }

        long[] arr = ans.stream().mapToLong(Integer::longValue).toArray();
        return arr;
    }

    public static void main(String[] args) {
        long[] nums = {4, 8, 9, -4, 1, -1, -8, -9};
        long[] ans = positiveNegativePairs(nums, nums.length);
        System.out.println(Arrays.toString(ans));
    }
}
