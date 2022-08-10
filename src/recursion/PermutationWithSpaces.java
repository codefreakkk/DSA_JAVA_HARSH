package recursion;

import java.util.*;

public class PermutationWithSpaces {
    public static void solve(String input, String output, ArrayList<String> answer) {
        if(input.length() == 0) {
            answer.add(output);
            return;
        }

        char ch = input.charAt(0);
        solve(input.substring(1), output + " "+ch, answer);
        solve(input.substring(1), output + ch, answer);
        return;
    }

    public static ArrayList<String> permuteWithSpaces(String s) {
        ArrayList<String> answer = new ArrayList<>();
        solve(s.substring(1), String.valueOf(s.charAt(0)), answer);
        return answer;
    }

    public static void main(String args[]) {
        List<String> answer = permuteWithSpaces("AB");
        System.out.println(answer);
    }
}