package REVISION.recursion.backtracking;

public class Sudoku {
    public static boolean isSafeToMove(int[][] grid, int row, int col, int value) {
        int n = grid.length;

        for(int i = 0; i < n; i++) {
            if(grid[row][i] == value || grid[i][col] == value) return false;
            if(grid[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] == value) return false;
        }

        return true;
    }

    public static boolean solveSudoku(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    for(int k = 1; k <= 9; k++) {
                        if(isSafeToMove(grid, i, j, k)) {
                            grid[i][j] = k;
                            boolean canMoveFurther = solveSudoku(grid);
                            if(canMoveFurther) return true;
                            else grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {

    }
}
