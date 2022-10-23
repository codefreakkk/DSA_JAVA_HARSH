package contests.leetcode.WeeklyContest316;

import java.util.*;

public class ProblemB {
    public static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public static int subArrayGCD(int[] nums, int k) {
        // edge case
        if(nums.length == 1) {
            if(nums[0] == k) return 1;
            return 0;
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        if(nums[0] == k) count++;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == k) count++;
            int value = list.get(list.size() - 1);

            if(gcd(value, nums[i]) == k) {
                count++;
                list.remove(list.size() - 1);
                list.add(k);
                continue;
            }
            list.add(nums[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4};
        int k = 4;
        System.out.println(subArrayGCD(nums, k));
    }
}
