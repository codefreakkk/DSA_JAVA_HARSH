package recursion;

import java.util.ArrayList;

public class PhoneKeypad {
//    this is not actuall solution (kunal solution not accurate)
    public static void letterCombination(String processed, String string) {
        if(string.isEmpty()) {
            System.out.println(processed);
            return;
        }
        int digit =  string.charAt(0) - '0';
        int last = digit * 3;
        if(last == 27) {
            last = 26;
        }
        for(int i = (digit - 1) * 3; i < last; i++) {
            char ch = (char) ('a' + i);
            letterCombination(processed + ch, string.substring(1));
        }
    }

    public static void main(String[] args) {
        letterCombination("", "77");
    }
}
