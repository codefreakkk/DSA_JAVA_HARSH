package recursion;

import java.util.*;

public class NBitBinaryNumbersHaving1GreaterThan0 {
    public static void solve(int N, int one, int zero, String output, ArrayList<String> answer) {
        if(N == 0) {
            answer.add(output);
            return;
        }

        solve(N - 1, one + 1, zero, output + "1", answer);
        if(one > zero) {
            solve(N - 1, one, zero + 1, output + "0", answer);
        }
        return;
    }

    public static ArrayList<String> NBitBinary(int N) {
        ArrayList<String> answer = new ArrayList<>();
        solve(N, 0, 0, "", answer);
        return answer;
    }

    public static void main(String args[]) {
        List<String> answer = NBitBinary(2);
        for(String i : answer) {
            System.out.println(i);
        }
    }
}