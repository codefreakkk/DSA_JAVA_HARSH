package REVISION.recursion;

import java.util.*;

public class CombinationSum2 {
    public static void solve(int[] nums, int rem, int index, List<Integer> output, List<List<Integer>> ans) {
        if(rem == 0) {
            ans.add(new ArrayList<>(output));
        }

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            if(nums[i] > rem) break;

            output.add(nums[i]);
            solve(nums, rem - nums[i], i + 1, output, ans);
            output.remove(output.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, target, 0,  new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> ans = combinationSum2(nums, target);
        for(List<Integer> i : ans) System.out.println(i);
    }
}
