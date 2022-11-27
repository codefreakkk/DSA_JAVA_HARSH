package StackQueue.stack;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void solve(String s, int size, int removal, HashMap<String, Boolean> map, List<String> ans) {
        // if map contains same combination return
        if(map.containsKey(s)) return;

        map.put(s, true);

        if(removal == 0) {
            int removalsNeeded = findRemovals(s, s.length());
            // if valid combination found add to answer
            if(removalsNeeded == 0) {
                ans.add(s);
            }
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            String join = left + right;
            solve(join, join.length(), removal - 1, map, ans);
        }
    }


    // find how many invalid parentheses are present in a string
    public static int findRemovals(String s, int size) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < size; i++) {
            char value = s.charAt(i);
            if(value == '(') stack.push(value);
            else if(value == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(value);
            }
        }

        return stack.size();
    }

    public static List<String> removeInvalidParentheses(String s) {
        HashMap<String, Boolean> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        int size = s.length();

        int removal = findRemovals(s, size);
        solve(s, size, removal, map, ans);

        return ans;
    }

    public static void main(String[] args) {
        String s = "(()()";
        List<String> ans = removeInvalidParentheses(s);
        System.out.println(ans);

    }
}
