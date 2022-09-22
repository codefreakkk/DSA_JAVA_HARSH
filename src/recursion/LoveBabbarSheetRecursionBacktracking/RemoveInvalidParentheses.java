package recursion.LoveBabbarSheetRecursionBacktracking;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void solve(String s, int removal, HashMap<String, Boolean> map, List<String> ans) {
        // avoid duplicates
        if(map.containsKey(s)) return;
        map.put(s, true);

        if(removal == 0) {
            int isValidCount = getInvalidElement(s);
            if(isValidCount == 0) ans.add(s);
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            String output = left + right;
            solve(output, removal - 1, map, ans);
        }
    }

    public static int getInvalidElement(String s) {
        int size = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < size; i++) {
            char value = s.charAt(i);
            if(s.charAt(i) == '(') stack.push(value);
            else if(value == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else stack.push(value);
            }
        }
        return stack.size();
    }

    public static List<String> removeInvalidParentheses(String s) {
        HashMap<String, Boolean> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        int removal = getInvalidElement(s);
        solve(s, removal, map, ans);

        return ans;
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        List<String> ans = removeInvalidParentheses(s);
        for(String i : ans) System.out.println(i);
    }
}
