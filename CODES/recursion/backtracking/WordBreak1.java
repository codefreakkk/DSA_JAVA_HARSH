package recursion.backtracking;

import java.util.*;

public class WordBreak1 {
//    problem will not work for some test cases (require dynamic programming here)
    public static boolean solve(String s, Set<String> dict, int start) {
        if(start == s.length()) return true;

        for(int end = start + 1; end <= s.length(); end++) {
            if(dict.contains(s.substring(start, end)) && solve(s, dict, end)) {
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> dict) {
        return solve(s, new HashSet<>(dict), 0);
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> dict = new ArrayList<>();
        dict.add("aaaa");
        dict.add("aaa");

        System.out.println(wordBreak(s, dict));
    }
}