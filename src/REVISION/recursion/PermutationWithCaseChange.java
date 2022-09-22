package REVISION.recursion;

import java.util.*;

public class PermutationWithCaseChange {
    public static void solve(String output, String input, List<String> ans) {
        if(input.isEmpty()) {
            ans.add(output);
            return;
        }

        char value = input.charAt(0);

        if(Character.isDigit(value)) solve(output + value,  input.substring(1), ans);
        else {
            solve(output + value, input.substring(1), ans);
            solve(output + Character.toUpperCase(value), input.substring(1), ans);
        }
     }

    public static List<String> listCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        solve("", s, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "3z4";
        List<String> ans = listCasePermutation(s);
        System.out.println(ans);
    }
}
