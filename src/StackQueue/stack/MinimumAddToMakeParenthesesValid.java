package StackQueue.stack;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    // stack approach TC - o(n), sc - o(n)
    public static int minAddToMakeValid1(String s) {
        if(s.length() == 0) return 0;

        Stack<Character> stack = new Stack<>();

        int size = s.length(), cnt = 0;

        for(int i = 0; i < size; i++) {
            if(s.charAt(i) == '(') stack.push('(');
            else {
                if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else cnt++;
            }
        }

        cnt += stack.size();
        return cnt;
    }

    public static int minAddToMakeValid(String s) {
        if(s.length() == 0) return 0;

        int bal = 0, cnt = 0, size = s.length();

        for(int i = 0; i < size; i++) {
            char val = s.charAt(i);

            bal += val == '(' ? 1 : -1;

            if(bal == -1) {
                cnt += 1;

                // if bal is -1 than make it 1 bcoz now current parentheses is valid
                bal += 1;
            }
        }

        // bal + cnt because there might be some value left in bal
        return bal + cnt;

    }

    public static void main(String[] args) {
        String s = "())(()";
        System.out.println(minAddToMakeValid(s));
    }
}
