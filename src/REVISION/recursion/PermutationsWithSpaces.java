package REVISION.recursion;

import java.util.ArrayList;

public class PermutationsWithSpaces {
    public static void solve(String input, String output, ArrayList<String> ans) {
        if(input.isEmpty()) {
            ans.add(output);
            return;
        }

        char value = input.charAt(0);
        solve(input.substring(1), output + " " + value, ans);
        solve(input.substring(1), output + value, ans);
    }

    public ArrayList<String> permutationWithSpaces(String s) {
        ArrayList<String> ans = new ArrayList<>();

        String output = String.valueOf(s.charAt(0));
        String input = s.substring(1);

        solve(input, output, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
