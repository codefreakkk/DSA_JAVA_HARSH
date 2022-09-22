package REVISION.recursion;

import java.util.*;

public class MaximumLengthOfConcatedString {
    public static boolean check(String current, int[] visited) {
        // check for self first
        int[] self = new int[26];
        for(int i = 0; i < current.length(); i++) {
            if(self[current.charAt(i) - 'a'] == 1) return true;
            self[current.charAt(i) - 'a'] = 1;
        }

        // check unique for whole string
        for(int i = 0; i < current.length(); i++) {
            if(visited[current.charAt(i) - 'a'] == 1) return true;
        }

        // if the current string is unique return false
        return false;
    }

    public static int solve(List<String> arr, int index, int length, int[] visited) {
        if(index >= arr.size()) {
            return length;
        }

        String value = arr.get(index);
        // check if value is not unique if it is not than go to next index
        if(check(value, visited)) {
            // string is not unique
            return solve(arr, index + 1, length, visited);
        }
        else {
            // mark visited array
            for(int i = 0; i < value.length(); i++) visited[value.charAt(i) - 'a'] = 1;
            int leftMax = solve(arr, index + 1, length + value.length(), visited);

            for(int i = 0; i < value.length(); i++) visited[value.charAt(i) - 'a'] = 0;
            int rightMax = solve(arr, index + 1, length, visited);

            return Math.max(leftMax, rightMax);
        }
    }

    public static int maxLength(List<String> arr) {
        int[] visited = new int[26];
        return solve(arr, 0, 0, visited);
    }

    public static void main(String[] args) {
        List<String> str = List.of("un", "iq", "ue");
        System.out.println(maxLength(str));
    }
}
