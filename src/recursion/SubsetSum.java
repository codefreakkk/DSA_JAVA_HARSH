package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetSum {
    static void solve(ArrayList<Integer> nums, ArrayList<Integer> answer, int sum, int index) {
        if(index == nums.size()) {
            answer.add(sum);
            return;
        }

        solve(nums, answer, sum + nums.get(index), index + 1);
        solve(nums, answer, sum, index + 1);
        return;
    }

    static ArrayList<Integer> subsetSums(ArrayList<Integer> nums, int N) {
        ArrayList<Integer> answer = new ArrayList<>();
        solve(nums, answer, 0, 0);
        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(2);
        nums.add(1);
        System.out.println(subsetSums(nums, nums.size()));
    }
}
