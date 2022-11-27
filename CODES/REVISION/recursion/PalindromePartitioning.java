package REVISION.recursion;

import java.util.*;

public class PalindromePartitioning {
    public static boolean isPartitionPossible(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    public static void solve(String s, List<String> output, List<List<String>> ans) {
        if(s.isEmpty()) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            if(isPartitionPossible(s.substring(0, i + 1))) {
                output.add(s.substring(0, i + 1));
                solve(s.substring(i + 1), output, ans);
                output.remove(output.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> ans = partition(s);
        for(List<String> l : ans) System.out.println(l);
    }
}
