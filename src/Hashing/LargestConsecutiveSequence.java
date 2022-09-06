package Hashing;

import java.util.*;

public class LargestConsecutiveSequence {

//    brute force approach with TC : o(NlogN) + o(N)
    public static int longestConsecutiveSequence1(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 0 && nums[0] == 0) return 1;
        Arrays.sort(nums);
        int size = nums.length;
        int cnt = 1, maxi = Integer.MIN_VALUE;

        for(int i = 1; i < size; i++) {
            if(nums[i] == nums[i - 1] + 1) cnt++;
            else if(nums[i] == nums[i - 1]) continue;
            else cnt = 1;
            maxi = Integer.max(maxi, cnt);
        }

        maxi = Integer.max(maxi, cnt);
        return maxi;
    }

//    optimised approach with TC : o(N) + o(N) + o(N), SC : o(N)
    public static int longestConsecutiveSequence(int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet<>();
        int cnt = 0, maxi = Integer.MIN_VALUE;

        for(int i = 0; i < size; i++) set.add(nums[i]);

        for(int i = 0; i < size; i++) {
            if(!set.contains(nums[i] - 1)) {
                int j = nums[i];
                while(true) {
                    if(set.contains(j++)) cnt++;
                    else break;
                }
            }
            maxi = Integer.max(maxi, cnt);
            cnt = 0;
        }

        return maxi;
    }


    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutiveSequence(nums));
    }

}
