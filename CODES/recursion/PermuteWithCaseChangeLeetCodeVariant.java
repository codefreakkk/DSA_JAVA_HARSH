package recursion;

import java.util.*;

public class PermuteWithCaseChangeLeetCodeVariant {
//    leetcode 784
//    appraoch if character ignore it and if the letters are in upper case than we need to get letters with the combination of lower case and vice versa
//    so call the recursion in if and else block for both the upper case & lower case condtion
    static void solve(String output, String input, List<String> answer) {
        if(input.length() == 0) {
            answer.add(output);
            return;
        }

        char ch = input.charAt(0);
//        if the character is digit than just add it in output do not to further recursion call
        if(Character.isDigit(ch)) {
            solve(output + ch, input.substring(1), answer);
        } else {
//          if the character ch is lowecase than we need to get the answer of permutation mixed with upper case letters
            if(Character.isLowerCase(ch)) {
                solve(output + ch, input.substring(1), answer);
                solve(output + Character.toUpperCase(ch), input.substring(1), answer);
            }
//          if the character ch is lowecase than we need to get the answer of permutation mixed with lower case letters
            if(Character.isUpperCase(ch)) {
                solve(output + ch, input.substring(1), answer);
                solve(output + Character.toLowerCase(ch), input.substring(1), answer);
            }
            return;
        }
    }

    static List<String> permute(String str) {
        List<String> answer = new ArrayList<>();
        solve("", str, answer);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(permute("ZZ"));
    }
}
