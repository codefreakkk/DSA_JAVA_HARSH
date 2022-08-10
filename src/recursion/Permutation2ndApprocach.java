package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation2ndApprocach {
//    permutation second approach by swapping numbers (permutation in increasing order)
    static void permutation(String str, int index) {
        if(index >= str.length() - 1) {
            System.out.println(str);
            return;
        }
        for(int i = index; i < str.length(); i++) {
//            swap i and index
            char ch[] = str.toCharArray();
            char temp = ch[i];
            ch[i] = ch[index];
            ch[index] = temp;
            permutation(String.valueOf(ch), index + 1);
        }
    }

    static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void solve(int nums[], int index, List<Integer> output, List<List<Integer>> answer) {
        if(index >= nums.length - 1) {
//            convert array to list via stream API
            answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            solve(nums, index + 1, output, answer);
//            backtracking
            swap(nums, i, index);
        }
    }
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        List<List<Integer>> ans = permute(arr);
        for(List<Integer> i : ans) {
            System.out.println(i);
        }
    }
}
