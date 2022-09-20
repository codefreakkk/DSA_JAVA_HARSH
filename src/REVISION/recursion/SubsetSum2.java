package REVISION.recursion;

import java.util.*;

public class SubsetSum2 {
    public static void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(output));

        for(int i =  index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            output.add(nums[i]);
            solve(nums, i + 1, output, ans);
            output.remove(output.size() - 1);
        }
    }

    public static List<List<Integer>> subsetWithoutDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = subsetWithoutDuplicates(nums);
        for(List<Integer> l : ans) System.out.println(l);
    }
}
