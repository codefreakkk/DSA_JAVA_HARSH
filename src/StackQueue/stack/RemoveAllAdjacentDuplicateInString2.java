package StackQueue.stack;

import java.util.*;

class Pair {
    char ch;
    int count;

    public Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }

    public char getChar() {
        return this.ch;
    }

    public int getValue() {
        return this.count;
    }
}

public class RemoveAllAdjacentDuplicateInString2 {


    // wrong solution


//    public static String removeAdjacentDuplicates(String s, int k) {
//        int size = s.length();
//        String ans = "";
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        Stack<Character> stack = new Stack<>();
//
//        for(int i = 0; i < size; i++) {
//            char value = s.charAt(i);
//
//            // put value in map and increase frequency
//            if(map.containsKey(value)) map.put(value, map.get(value) + 1);
//            else map.put(value, 1);
//
//
//            if(!stack.isEmpty() && stack.peek() == value) {
//                // if k is equal to stack
//                if(map.get(value) >= k) {
//                    // update ans and remove duplicate elements from stack
//                    int len = ans.length() - (k - 1);
//                    ans = ans.substring(0, len);
//                    while(!stack.isEmpty() && stack.peek() == value) {
//                        stack.pop();
//                    }
//
//                    map.put(value, 0);
//                }
//                else  {
//                    stack.push(value);
//                    // concat value to ans
//                    ans += value;
//                }
//            }
//            else {
//                stack.push(value);
//                // concat value to ans
//                ans += value;
//            }
//        }
//
//        return ans;
//    }

    public static String removeAdjacentDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        int size = s.length();

        for(int i = 0; i < size; i++) {
            char ch = s.charAt(i);

            if(stack.isEmpty()) {
                stack.push(new Pair(ch, 1));
                continue;
            }

            Pair pair = stack.peek();
            if(pair.getChar() != ch) {
                stack.push(new Pair(ch, 1));
            } else {
                if(pair.getValue() == k - 1) {
                    stack.pop();
                }
                else pair.count++;
            }
        }

        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()) {
            Pair element = stack.pop();
            for(int i = 0; i < element.getValue(); i++) {
                str.append(element.getChar());
            }
        }

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy";
        int k = 4;

        System.out.println(removeAdjacentDuplicates(s, k));
    }
}
