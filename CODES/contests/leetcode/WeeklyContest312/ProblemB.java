package contests.leetcode.WeeklyContest312;

import java.util.*;

public class ProblemB {
    public static int longestSubarray(int[] nums) {
        int maxElement = Arrays.stream(nums).max().getAsInt();

        int len = 0, current = 0;
        for(int val : nums) {
            if(val == maxElement) current++;
            else {
                len = Math.max(len, current);
                current = 0;
            }
        }
        len = Math.max(len, current);

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(longestSubarray(nums));
    }
}
