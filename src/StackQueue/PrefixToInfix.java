package StackQueue;

public class PrefixToInfix extends PostfixToInfix {
    public static String stringReverse(String s) {
        String answer = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            char item = s.charAt(i);
            if(item == '(') answer += ')';
            else if(item == ')') answer += '(';
            else answer += item;
        }
        return answer;
    }

    public static String prefixToInfix(String s) {
        String reverse = stringReverse(s);
        String answer = postfixToInfix(reverse);
        return stringReverse(answer);
    }

    public static void main(String[] args) {
        String s = "*-A/BC-/AKL";
        System.out.println(prefixToInfix(s));
    }
}
