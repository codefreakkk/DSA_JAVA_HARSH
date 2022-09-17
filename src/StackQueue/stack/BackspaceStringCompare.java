package StackQueue.stack;

import java.util.*;

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        int size1 = s.length();
        int size2 = t.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < size1; i++) {
            char value = s.charAt(i);
            if(!stack.isEmpty() && value == '#') stack.pop();
            else {
                if(value != '#') stack.push(value);
            }
        }

        StringBuilder str1 = new StringBuilder();
        while(!stack.isEmpty()) str1.append(stack.pop());

        for(int i = 0; i < size2; i++) {
            char value =  t.charAt(i);
            if(!stack.isEmpty() && value == '#') stack.pop();
	        else {
                if(value != '#') stack.push(value);
            }
        }

        StringBuilder str2 = new StringBuilder();
        while(!stack.isEmpty()) str2.append(stack.pop());

        return str1.toString().equals(str2.toString());
    }

    public static void main(String[] args) {
        String s = "ab##", t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }
}
