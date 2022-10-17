package contests.leetcode.weeklyContest315;

import java.util.*;

public class ProblemB {
    public static int reverseDigit(int n) {
        StringBuilder string = new StringBuilder(String.valueOf(n));
        String rev = string.reverse().toString();
        return Integer.parseInt(rev);
    }

    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
            set.add(reverseDigit(i));
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        System.out.println(countDistinctIntegers(nums));
    }
}
