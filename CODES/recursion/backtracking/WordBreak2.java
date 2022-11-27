package recursion.backtracking;

import java.util.*;


// -----------problem not solved-----------

public class WordBreak2 {
    public static void solve(int n, List<String> dict, String s, int index, List<String> output, List<String> answer) {
        if(s.isEmpty()) {
            String ans = "";
            for(String i : output) {
                ans += i + " ";
            }
            answer.add(ans.trim());
            return;
        }
        if(index == n) return;

        for(int i = index; i < n; i++) {
            if(s.startsWith(dict.get(i))) {
                output.add(dict.get(i));
                solve(n, dict, s.substring(dict.get(i).length(), s.length()), i + 1, output, answer);
                output.remove(output.size() - 1);
            }
        }
    }

    public static List<String> wordBreak(int n, List<String> dict, String s) {
        List<String> answer = new ArrayList<>();
        int index = 0;
        solve(n, dict, s, index, new ArrayList<>(), answer);
        return answer;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("rcbyn");
        dict.add("dy");
        dict.add("rcbyndy");
        dict.add("xx");
        dict.add("lorel");
        int n = dict.size();
        String s = "rcbyndyxxrcbyndyxx";

        List<String> answet = wordBreak(n, dict, s);
        for(String i : answet) {
            System.out.println(i);
        }

    }
}