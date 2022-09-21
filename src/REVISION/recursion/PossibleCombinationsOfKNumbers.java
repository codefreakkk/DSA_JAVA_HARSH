package REVISION.recursion;

import java.util.*;

public class PossibleCombinationsOfKNumbers {
    public static void solve(int n, int k, int index, List<Integer> output, List<List<Integer>> ans) {
        if(k == output.size()) {
            ans.add(new ArrayList<>(output));
            return;
        }
        if(index > n) return;

        output.add(index);
        solve(n, k, index + 1, output, ans);
        output.remove(output.size() - 1);
        solve(n, k, index + 1, output, ans);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = combine(4, 2);
        for(List<Integer> li : ans) System.out.println(li);
    }
}
