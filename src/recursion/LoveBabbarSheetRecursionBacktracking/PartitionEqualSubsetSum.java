package recursion.LoveBabbarSheetRecursionBacktracking;

import java.util.*;

public class PartitionEqualSubsetSum {

    public static int solve(int[] nums, int ans, int sum) {
        if(ans == sum) {
            return 1;
        }
        if(ans > sum) return 0;

        for(int i = 0; i < nums.length; i++) {
            return solve(nums, ans + nums[i], sum);
        }

        return 0;
    }

    public static int equalPartition(int[] arr, int n) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if(sum % 2 != 0) return 0;

        return solve(arr, 0, sum / 2);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(equalPartition(nums, nums.length));
    }
}
