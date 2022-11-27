package recursion.backtracking;

public class Sudoku {
    static boolean isSafeToMove(int[][] board, int row, int col, int val) {
        for(int i = 0; i < board.length; i++) {
            if(board[row][i] == val || board[i][col] == val) {
                return false;
            }
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) {
                return false;
            }
        }
        return true;
    }
    static boolean solve(int [][] board) {
        int size = board.length;
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if(board[row][col] == 0) {
                    for(int val = 1; val <= 9; val++) {
                        if(isSafeToMove(board, row, col, val)) {
                            board[row][col] = val;
                            boolean canMoveFurther = solve(board);
                            if(canMoveFurther) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void solveSudoku(int[][] board) {
        solve(board);
    }

    public static void main(String[] args) {

    }
}
