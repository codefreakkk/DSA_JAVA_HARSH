package recursion;

import java.util.ArrayList;

public class Permutations {
    static void permutation(String processed, String str) {
        if(str.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = str.charAt(0);
        for(int i = 0; i <= processed.length(); i++) {
            String start = processed.substring(0, i);
            String end = processed.substring(i, processed.length());
            permutation(start + ch + end, str.substring(1));
        }
    }
    static ArrayList<String> permutationList(String processed, String str) {
        if(str.isEmpty()) {
            ArrayList<String> permutations = new ArrayList<>();
            permutations.add(processed);
            return permutations;
        }
        char ch = str.charAt(0);
        ArrayList<String> answer = new ArrayList<>();
        for(int i = 0; i <= processed.length(); i++) {
            String start = processed.substring(0, i);
            String end = processed.substring(i, processed.length());
            answer.addAll(permutationList(start + ch + end, str.substring(1)));
        }
        return answer;
    }
    static int countPermutation(String processed, String str) {
        if(str.isEmpty()) {
            return 1;
        }
        //        taking count variable inside the function call and not in the parameter and argument
        int count = 0;
        char ch = str.charAt(0);
        for(int i = 0; i <= processed.length(); i++) {
            String start = processed.substring(0, i);
            String end = processed.substring(i, processed.length());
            count += countPermutation(start + ch + end, str.substring(1));
        }
        return count;
    }

    public static void main(String[] args) {
        permutation("", "ABC");
    }
}
