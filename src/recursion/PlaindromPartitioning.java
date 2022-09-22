package recursion;

import java.util.ArrayList;
import java.util.List;

public class PlaindromPartitioning {
    static boolean isPartitionValid(String s, int start, int end) {
       while(start <= end) {
           if(s.charAt(start++) != s.charAt(end--)) {
               return false;
           }
       }
       return true;
    }

    static void solve(String s, int index, List<String> output, List<List<String>> answer) {
        if(index == s.length()) {
            answer.add(new ArrayList<>(output));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if(isPartitionValid(s, index, i)) {
                output.add(s.substring(index, i + 1));
                solve(s, i + 1, output, answer);
                output.remove(output.size() - 1);
            }
        }
    }

    static List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), answer);
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> answer = partition("geeks");
        for(List<String> i : answer) {
            System.out.println(i);
        }
    }
}
