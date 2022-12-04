package contests.leetcode.WeeklyContest322;

public class ProblemA {
    public static boolean isCircularSentence(String sentence) {
        int size = sentence.length();
        char firstCharacter = sentence.charAt(0);
        char character = firstCharacter;

        int i = 0;
        while(i < size) {
            if(sentence.charAt(i) == ' ') {
                i++;
                if(character != sentence.charAt(i)) return false;
            }
            character = sentence.charAt(i);
            i++;
        }

        return firstCharacter == character;
    } 

    public static void main(String[] args) {
        String sentence = "Leetcode is cool";
        System.out.println(isCircularSentence(sentence));
    }
}
