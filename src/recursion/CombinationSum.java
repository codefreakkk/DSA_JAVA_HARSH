package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static void solve(int[] nums, int target, int index, List<Integer> output, List<List<Integer>> answer) {
        if(index >= nums.length) {
            if(target == 0) {
                answer.add(new ArrayList<>(output));
            }
            return;
        }
        if(nums[index] <= target) {
            output.add(nums[index]);
            solve(nums, target - nums[index], index, output, answer);
            output.remove(output.size() - 1);
        }
        solve(nums, target, index + 1, output, answer);
    }
    static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(nums, target, 0, output, answer);
        return answer;
    }

    public static void main(String[] args) {
        int nums[] = {8, 1, 8, 6, 8};
        List<List<Integer>> answer = combinationSum(nums, 5);
        for(List<Integer> i : answer) {
            System.out.println(i);
        }
    }
}
