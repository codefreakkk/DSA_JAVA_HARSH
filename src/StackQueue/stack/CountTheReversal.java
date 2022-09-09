package StackQueue.stack;

import java.util.Stack;

public class CountTheReversal {
    public static int countReversal(String str) {
        Stack<Character> stack = new Stack<>();
        int size = str.length();
        int a = 0, b = 0;

        if(size % 2 == 1) return -1;

        // remove all valid parentheses
        for(int i = 0; i < size; i++) {
            char item = str.charAt(i);
            if(item == '{') {
                stack.push('{');
                a++;
            }
            else {
                if(!stack.isEmpty() && stack.peek() == '{') {
                    a--;
                    stack.pop();
                }
                else {
                    stack.push(item);
                    b++;
                }
            }
        }

        int answer = ((a + 1) / 2) + ((b + 1) / 2);
        return answer;
    }

    public static void main(String[] args) {
        String str = "{}{{";
        System.out.println(countReversal(str));
    }
}
