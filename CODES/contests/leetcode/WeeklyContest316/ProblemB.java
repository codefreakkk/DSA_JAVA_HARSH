package contests.leetcode.WeeklyContest316;

import java.util.*;

public class ProblemB {
    public static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public static int subArrayGCD(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int gc = 0;
            for(int j = i; j < nums.length; j++) {
                gc = gcd(gc, nums[j]);
                if(gc == k) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4};
        int k = 4;
        System.out.println(subArrayGCD(nums, k));
    }
}
