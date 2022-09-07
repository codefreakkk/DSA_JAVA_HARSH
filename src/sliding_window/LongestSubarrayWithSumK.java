package sliding_window;

import java.util.HashMap;

public class LongestSubarrayWithSumK {

    // works only for positive integers
    public static int lengthOfLongestSubarray1(int[] nums, int n, int k) {
        int i = 0, j = 0, sum = 0;
        int maxi = Integer.MIN_VALUE;

        while(j < n) {
            sum += nums[j];
            if(sum > k) {
                while(sum > k) {
                    sum -= nums[i++];
                }
            }
            if(sum == k) {
                int windowSize = j - i + 1;
                maxi = Integer.max(maxi , windowSize);
            }
            j++;
        }

        return maxi;
    }

    public static int lengthOfLongestSubarray(int[] nums, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxi = 0, sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum == k) {
                maxi = i + 1;
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if(map.containsKey(sum - k)) {
                if(maxi < (i - map.get(sum - k))) {
                    maxi = i - map.get(sum - k);
                }
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        int k = 0;
        System.out.println(lengthOfLongestSubarray(nums, nums.length, k));
    }
}
