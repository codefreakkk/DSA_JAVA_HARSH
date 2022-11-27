package REVISION.recursion;

import java.util.*;

public class PermutationWithMap {
    public static void solve(int[] nums, boolean[] frequency, List<Integer> output) {
        if(output.size() == nums.length) {
            System.out.println(output);
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!frequency[i]) {
                output.add(nums[i]);
                frequency[i] = true;
                solve(nums, frequency, output);
                output.remove(output.size() - 1);
                frequency[i] = false;
            }
        }
    }

    public static void permute(int[] nums) {
        boolean[] frequency = new boolean[nums.length];
        Arrays.fill(frequency, false);
        List<Integer> output = new ArrayList<>();
        solve(nums, frequency, output);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }
}
