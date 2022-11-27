package recursion.LoveBabbarSheetRecursionBacktracking;

import java.util.*;

public class PalindromicPartition {
    public static boolean isPartitionValid(String s) {
        StringBuilder str = new StringBuilder(s);
        return str.reverse().toString().equals(s);
    }

    public static void solve(String s, int index, ArrayList<String> output, ArrayList<ArrayList<String>> ans) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if(isPartitionValid(s.substring(index, i + 1))) {
                output.add(s.substring(index, i + 1));
                solve(s, i + 1, output, ans);
                output.remove(output.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<String>> palindromicPartition(String s) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    public static void main(String[] args) {
        String s = "geeks";
        ArrayList<ArrayList<String>> ans = palindromicPartition(s);

        for(ArrayList<String> i : ans) System.out.println(i);
    }
}
