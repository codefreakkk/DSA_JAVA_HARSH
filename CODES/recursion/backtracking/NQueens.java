package recursion.backtracking;

import java.util.Arrays;

public class NQueens {
    static void display(boolean board[][]) {
        for(boolean b[] : board) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }
    static boolean isSafeToMove(boolean[][] board, int row, int col) {
        for(int i = 0; i < row; i++) {
            if(board[i][col]) {
                return false;
            }
        }
        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++) {
            if(board[row - i][col - i]) {
                return false;
            }
        }
        int maxRight = Math.min(row, board.length - col - 1);
        for(int i = 1; i <= maxRight; i++) {
            if(board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }
    static int queens(boolean[][] board, int row) {
        if(row == board.length) {
            display(board);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            if(isSafeToMove(board, row, i)) {
                board[row][i] = true;
                count += queens(board, row + 1);
                board[row][i] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(queens(new boolean[4][4], 3));
    }
}

