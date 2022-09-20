package REVISION.recursion;

import java.util.*;

public class SubsequenceWithSumK {

    // print subsequence with sum k
    public static void solve(int[] nums, int k, int sum, int index, List<List<Integer>> ans, List<Integer> output) {
        if(sum > k) return;
        if(index >= nums.length) {
            if(sum == k) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }

        output.add(nums[index]);
        solve(nums, k, sum + nums[index], index + 1, ans, output);
        output.remove(output.size() - 1);
        solve(nums, k, sum, index + 1, ans, output);
    }

    public static List<List<Integer>> subsequenceWithSumK(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, k, 0, 0, ans, new ArrayList<>());
        return ans;
    }

    // print only one subsequence with sum k
    public static boolean solve(int[] nums, int k, int sum, int index, List<Integer> output) {
        if(index >= nums.length) {
            System.out.println(output);
            return true;
        }

        output.add(nums[index]);
        if(solve(nums, k, sum + nums[index], index + 1, output)) return true;
        output.remove(output.size() - 1);
        if(solve(nums, k, sum, index + 1, output)) return true;
        return true;
    }

    public static void printOnlyOneSubsequence(int[] nums, int k) {
        solve(nums, k, 0, 0, new ArrayList<>());
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 1};
//        List<List<Integer>> ans = subsequenceWithSumK(nums, 2);
//        for(List<Integer> list : ans) {
//            System.out.println(list);
//        }
        int[] nums = {1,2,1};
        printOnlyOneSubsequence(nums, 2);
    }
}
