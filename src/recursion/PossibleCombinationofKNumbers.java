package recursion;

import java.util.*;

public class PossibleCombinationofKNumbers {
//    leetcode problem 77
    public static void solve(int n, int k, int index, List<Integer> output, List<List<Integer>> answer) {
        if(output.size() == k) {
            answer.add(new ArrayList<>(output));
            return;
        }
        if(index > n) {
            return;
        }
        output.add(index);
        solve(n, k, index + 1, output, answer);
        output.remove(output.size() - 1);
        solve(n, k, index + 1, output, answer);
        return;
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        solve(n, k, 1, output, answer);
        return answer;
    }

    public static void main(String args[]) {
        List<List<Integer>> answer = combine(4, 1);
        for(List<Integer> i : answer) {
            System.out.println(i);
        }
    }
}