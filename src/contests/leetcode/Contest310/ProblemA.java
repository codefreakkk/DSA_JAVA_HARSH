package contests.leetcode.Contest310;

import java.util.*;

public class ProblemA {
    public static int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map  = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int element = -1;
        int size = nums.length;

        for(int i = 0; i < size; i++) {
            if(nums[i] % 2 == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        Arrays.sort(nums);

        for(int i = 0; i < size; i++) {
            if(map.containsKey(nums[i]) && max < map.get(nums[i])) {
                max = map.get(nums[i]);
                element = nums[i];
            }
        }

        return element;
    }

    public static void main(String[] args) {
        int[] nums = {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};
        System.out.println(mostFrequentEven(nums));
    }
}
