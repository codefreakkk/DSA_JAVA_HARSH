package sliding_window;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subArraySum(int[] nums, int k) {
        if(nums.length == 1 && k == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0, sum = 0;
        int size = nums.length;
        map.put(0, 1);

        for(int i = 0; i < size; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                total += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subArraySum(nums, k));
    }
}
