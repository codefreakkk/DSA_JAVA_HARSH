package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum2 {
    public static void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(output));
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            output.add(nums[i]);
            solve(nums, i + 1, output, answer);
            output.remove(output.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithoutDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void main(String[] args) {
         int[] nums = {1, 2, 2};
         List<List<Integer>> answer = subsetsWithoutDuplicates(nums);
         for(List<Integer> i : answer) {
             System.out.println(i);
         }
    }
}
