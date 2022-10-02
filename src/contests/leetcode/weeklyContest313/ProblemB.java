package contests.leetcode.weeklyContest313;

public class ProblemB {

    public static int getMaxSum(int[][] grid, int row, int col, int n, int m) {
        int sum = 0;
        for(int i = row; i <= n; i++) {
            for(int j = col; j <= m; j++) {
                if((i == row + 1 && j == col) || (i == row + 1 && j == col + 2)) {
                    continue;
                }
                sum += grid[i][j];
            }
        }

        return sum;
    }

    public static int maxSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i + 2 < row && j + 2 < col) {
                    max = Math.max(max, getMaxSum(grid, i, j, i + 2, j + 2));
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {6, 2, 1, 3},
                {4, 2, 1, 5},
                {9, 2, 8, 7},
                {4, 1, 2, 9}
        };
        System.out.println(maxSum(nums));
    }
}
