package REVISION.recursion;

import java.util.*;

public class PermutationRecursionSwap {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void solve(int[] nums, int index) {
        if(index >= nums.length - 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            // swap with all
            swap(nums, i, index);
            solve(nums, index + 1);
            swap(nums, i, index);
        }
    }

    public static void permute(int[] nums) {
        solve(nums, 0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }
}
