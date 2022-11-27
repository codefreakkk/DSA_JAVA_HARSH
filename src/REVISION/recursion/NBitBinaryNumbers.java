package REVISION.recursion;

import java.util.*;

public class NBitBinaryNumbers {
    public static void solve(int n, String output, int one, int zero, ArrayList<String> ans) {
        if(n == 0) {
            ans.add(output);
            return;
        }

        solve(n - 1, output + "1", one + 1, zero, ans);
        if(zero < one) solve(n - 1, output + "0", one, zero + 1, ans);
    }

    public static ArrayList<String> NBitBinary(int n) {
        ArrayList<String> ans = new ArrayList<>();
        solve(n - 1, "1", 1, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> ans = NBitBinary(3);
        System.out.println(ans);
    }
}
