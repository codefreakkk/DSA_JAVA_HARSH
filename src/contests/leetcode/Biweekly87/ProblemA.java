package contests.leetcode.Biweekly87;

import java.util.Arrays;

public class ProblemA {
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, cnt = 0;
        int size1 = players.length, size2 = trainers.length;

        while(i < size1 && j < size2) {
            if(players[i] <= trainers[j]) {
                i++;
                j++;
                cnt++;
            }
            else j++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] player = {4,7,9};
        int[] trainer = {8,2,5,8};

        System.out.println(matchPlayersAndTrainers(player, trainer));
    }
}
