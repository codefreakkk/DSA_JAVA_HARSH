package REVISION.recursion;

import java.util.ArrayList;

public class SubsetArray {
    public static void solve(int[] nums, ArrayList<Integer> output, int index) {
        if(index >= nums.length) {
            System.out.println(output);
            return;
        }

        output.add(nums[index]);
        solve(nums, output, index + 1);
        output.remove(output.size() - 1);
        solve(nums, output, index + 1);
    }

    public static void subset(int[] nums) {
        solve(nums, new ArrayList<>(), 0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        subset(nums);
    }
}
