package recursion.backtracking;

class SudokuLeetCode {
    public static boolean isSafeToMove(char[][] board, int row, int col, char val) {
        for(int i = 0; i < board.length; i++) {
            if(board[row][i] == val) {
                return false;
            }
            if(board[i][col] == val) {
                return false;
            }
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(char [][] board) {
        int size = board.length;
        for(int row = 0; row < size; row++) {
            for(int col = 0; col < size; col++) {
                if(board[row][col] == '.') {
                    for(char val = '1'; val <= '9'; val++) {
                        if(isSafeToMove(board, row, col, val)) {
                            board[row][col] = val;
                            boolean canMoveFurther = solve(board);
                            if(canMoveFurther) {
                                return true;
                            } else {
//                                backtrack
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}