package recursion;

import java.util.*;

public class GenerateParenthesesLeetcode {
    public static void solve(int opening, int closing, String output, List<String> answer) {
        if(opening == 0 && closing == 0) {
            answer.add(output);
            return;
        }
        if(opening != 0) {
            solve(opening - 1, closing, output + "(", answer);
        }
        if(closing > opening) {
            solve(opening, closing - 1, output + ")", answer);
        }
        return;
    }

    public static List<String> generateParentheses(int n) {
        List<String> answer = new ArrayList<>();
        solve(n, n, "", answer);
        return answer;
    }

    public static void main(String args[]) {
        List<String> answer = generateParentheses(3);
        for(String s : answer) {
            System.out.println(s);
        }
    }
}