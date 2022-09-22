package REVISION.recursion;

import java.util.*;

public class GenerateBalancedParentheses {
    public static void solve(int opening, int closing, String output, List<String> ans) {
        if(opening == 0 && closing == 0) {
            ans.add(output);
            return;
        }

        if(opening != 0) {
            solve(opening - 1, closing, output + "(", ans);
        }
        if(closing > opening) solve(opening, closing - 1, output + ")", ans);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, n, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);
    }
}
