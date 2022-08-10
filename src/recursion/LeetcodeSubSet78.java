package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeSubSet78 {
    private static void solve(int nums[], int index, List<Integer> output, List<List<Integer>> answer) {
        if(index >= nums.length) {
            answer.add(new ArrayList<>(output));
            return;
        }
        output.add(nums[index]);
        solve(nums, index + 1, output, answer);
        output.remove(output.size() - 1);
        solve(nums, index + 1, output, answer);
    }
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(nums, 0, output, answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> answer = subsets(nums);
        for(List<Integer> i : answer) {
            System.out.println(i);
        }
    }
}
