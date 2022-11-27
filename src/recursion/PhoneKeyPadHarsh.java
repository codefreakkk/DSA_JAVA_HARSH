package recursion;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeyPadHarsh {
//    this is the actual solution (accurate solution)
    static void combinationLetter(String digits, String output, int index, String[] mapping, List<String> answer) {
        if(index >= digits.length()) {
//            System.out.println(output);
            answer.add(output);
            return;
        }
        int positionofi = (int) digits.charAt(index) - '0';
        for(int i = 0; i < mapping[positionofi].length(); i++) {
            combinationLetter(digits, output + String.valueOf(mapping[positionofi].charAt(i)), index + 1, mapping, answer);
        }
     }
    static List<String> findCombinationLetter(String digits, String output, int index, String[] mapping) {
        List<String> answer = new ArrayList<>();
        combinationLetter(digits, output, index, mapping, answer);
        return answer;
    }
    public static void main(String[] args) {
        String[] mapping = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> answer = findCombinationLetter("2", "", 0, mapping);
        for(String i : answer) {
            System.out.println(i);
        }
    }
}
