package recursion;

import java.util.*;
import java.util.stream.*;

public class UniquePermutation {
    public static void swap(int[] nums, int i, int j) {
        int tempvalue = nums[i];
        nums[i] = nums[j];
        nums[j] = tempvalue;
    }

    public static void solve(int[] nums, int index, List<List<Integer>> answer) {
        if(index >= nums.length) {
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        Set<Integer> set= new HashSet<Integer>();
        for(int i = index; i < nums.length; i++) {
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, i, index);
            solve(nums, index + 1, answer);
            swap(nums, i, index);
        }
        return;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        solve(nums, 0, answer);
        return answer;
    }

    public static void main(String args[]) {
        int[] nums = {2, 2, 1, 1};
        List<List<Integer>> answer = permuteUnique(nums);
        for(List<Integer> i : answer) {
            System.out.println(i);
        }
    }
}