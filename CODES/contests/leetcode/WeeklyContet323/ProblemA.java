package contest.leetcode.WeeklyContet323;
import java.util.*;
public class ProblemA {
    public static int deleteGreatestValues(int[][] grid) {
        int sum = 0, count = grid[0].length, maximum = 0;
        while (count > 0) {
            for (int i = 0; i < grid.length; i++) {
                int max = 0, index = -1;
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        index = j;
                    }
                }
                grid[i][index] = -1;
                maximum = Math.max(maximum, max);
            }
            sum += maximum;
            maximum = 0;
            count--;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {10}
        };
        System.out.println(deleteGreatestValues(grid));
    }
}
