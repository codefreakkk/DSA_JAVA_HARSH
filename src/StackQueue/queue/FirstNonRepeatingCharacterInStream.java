package StackQueue.queue;

import java.util.*;

public class FirstNonRepeatingCharacterInStream {
    public static String firstNonRepeatingCharacter(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        int size = str.length();
        String ans = "";

        for(int i = 0; i < size; i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            queue.add(str.charAt(i));

            while(!queue.isEmpty()) {
                if(map.get(queue.peek()) > 1) queue.remove();
                else {
                    ans += queue.peek();
                    break;
                }
            }

            if(queue.isEmpty()) ans += '#';
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "zz";
        System.out.println(firstNonRepeatingCharacter(str));
    }
}
