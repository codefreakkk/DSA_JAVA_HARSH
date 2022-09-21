package REVISION.recursion;

import java.util.*;

public class CombinationSum3 {
    public static void solve(int k, int sum, int n, int index, List<Integer> output, List<List<Integer>> ans) {
        if(sum > n) return;
        if(k == 0) {
            if(sum == n) ans.add(new ArrayList<>(output));
            return;
        }

        if(index == 10) return;

        output.add(index);
        sum += index;
        solve(k - 1, sum, n, index + 1, output, ans);
        output.remove(output.size() - 1);
        sum -= index;
        solve(k, sum, n, index + 1, output, ans);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(k, 0,n, 1, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> li = combinationSum3(3, 7);
        for(List<Integer> i : li) System.out.println(i);
    }
}
