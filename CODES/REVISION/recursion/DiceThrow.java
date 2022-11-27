package REVISION.recursion;

import java.util.*;

public class DiceThrow {
    public static void solve(int rem, List<Integer> output, List<List<Integer>> ans) {
        if(rem == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for(int i = 1; i <= rem; i++) {
            output.add(i);
            solve(rem - i, output, ans);
            output.remove(output.size() - 1);
        }
    }

    public static List<List<Integer>> dice(int face) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(face, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        int face = 4;
        List<List<Integer>> ans = dice(face);

        for(List<Integer> i : ans) {
            System.out.println(i);
        }
    }
}
