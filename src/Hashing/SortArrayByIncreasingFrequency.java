package Hashing;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public static int[] frequencySort(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < size; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
		    else map.put(nums[i], 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue());

        int[] result = new int[size];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : list) {
            int key =  entry.getKey();
            int count = entry.getValue();

            while(count > 0) {
                result[index++] = key;
                count--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};
        int[] ans = frequencySort(nums);
        System.out.println(Arrays.toString(ans));
    }
}
