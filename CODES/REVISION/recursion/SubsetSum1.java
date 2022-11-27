package REVISION.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SubsetSum1 {
    public static void solve(ArrayList<Integer> nums, int n, int index, int sum, ArrayList<Integer> output) {
        if(index >= n) {
            output.add(sum);
            return;
        }

        solve(nums, n, index + 1, sum + nums.get(index), output);
        solve(nums, n, index + 1, sum, output);
        return;
    }

    public static ArrayList<Integer> subsetSum(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(arr, n, 0, 0, new ArrayList<>());
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);

        ArrayList<Integer> ans = subsetSum(nums, nums.size());
        System.out.println(ans);
    }
}
