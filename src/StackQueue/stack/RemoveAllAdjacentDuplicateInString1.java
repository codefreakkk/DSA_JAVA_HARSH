package StackQueue.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicateInString1 {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        String ans = "";
        int size = s.length();

        for(int i = 0; i < size; i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
                ans = ans.substring(0, ans.length() - 1);
            } else {
                ans += s.charAt(i);
                stack.push(s.charAt(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "azxxzy";
        System.out.println(removeDuplicates(s));
    }
}
