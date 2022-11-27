package REVISION.recursion;

import java.util.*;

public class CombinationSum {
    public static void solve(int[] nums, int index, int rem, List<Integer> output, List<List<Integer>> ans) {
        if(index >= nums.length) {
            if(rem == 0) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        if(rem >= nums[index]) {
            output.add(nums[index]);
            solve(nums, index, rem - nums[index], output, ans);
            output.remove(output.size() - 1);
        }
        solve(nums, index + 1, rem, output, ans);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = combinationSum(nums, target);
        for(List<Integer> list : ans) System.out.println(list);
    }
}
