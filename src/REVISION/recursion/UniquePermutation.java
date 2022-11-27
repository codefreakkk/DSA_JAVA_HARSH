package REVISION.recursion;

import java.util.*;
import java.util.stream.*;

public class UniquePermutation {
    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void solve(int[] nums, int index, List<List<Integer>> ans) {
        if(index >= nums.length) {
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = index; i < nums.length; i++) {
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, i, index);
            solve(nums, index + 1, ans);
            swap(nums, i, index);
        }
    }

    public static List<List<Integer>> uniquePermutation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> ans = uniquePermutation(nums);
        for(List<Integer> li : ans) System.out.println(li);
    }
}
