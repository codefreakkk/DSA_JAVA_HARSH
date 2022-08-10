package recursion;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    static void diceWithoutArrayList(String processed, int target) {
        if(target == 0) {
            System.out.println(processed);
            return;
        }
        for(int i = 1; i <= 6 && i <= target; i++) {
            diceWithoutArrayList(processed + i, target - i);
        }
    }
    static List<String> dice(String processed, int target) {
        if(target == 0) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> answer = new ArrayList<>();
        for(int i = 1; i <= 6 && i <= target; i++) {
            answer.addAll(dice(processed + i, target - i));
        }
        return answer;
    }

    public static void main(String[] args) {
        diceWithoutArrayList("", 4);
    }
}
