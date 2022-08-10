package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    static void solve(int[] nums, int target, int index, List<Integer> output, List<List<Integer>> answer) {
        if(target == 0) {
            answer.add(new ArrayList<>(output));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            if(nums[i] > target) {
                break;
            }
            output.add(nums[i]);
            solve(nums, target - nums[i], i + 1, output, answer);
            output.remove(output.size() - 1);
        }
    }

    static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, target, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2};
        int target = 4;
        List<List<Integer>> answer = combinationSum2(nums, target);
        for(List<Integer> i : answer) {
            System.out.println(i);
        }
    }
}
