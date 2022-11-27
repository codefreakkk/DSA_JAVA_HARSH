package REVISION.recursion.backtracking;

import java.util.Arrays;

public class KNights {
    public static void display(boolean[][] board) {
        for(boolean[] b : board) {
            System.out.println(Arrays.toString(b));
        }
    }

    public static boolean isValid(boolean[][] board, int row, int col) {
        if(row >= 0 && col >= 0 && row < board.length && col < board.length) return true;
        return false;
    }

    public static boolean isSafeToMove(boolean[][] board, int row, int col) {
        if(isValid(board, row - 1, col - 2)) {
            if(board[row - 1][col - 2]) return false;
        }
        if(isValid(board, row - 1, col + 2)) {
            if(board[row -1][col+2]) return false;
        }
        if(isValid(board, row - 2, col - 1)) {
            if(board[row -2][col-1]) return false;
        }
        if(isValid(board, row - 2, col + 1)) {
            if(board[row-2][col+1]) return false;
        }

        return true;
    }

    public static void solve(boolean[][] board, int knight, int row, int col) {
        if(knight == 0) {
            // display board
            System.out.println("hi");
            display(board);
            return;
        }

        // if you are in last row and all elements are over traversing
        if(row == board.length - 1 && col == board.length) return;

        if(col == board.length) {
            solve(board, knight, row + 1, 0);
            return;
        }

        if(isSafeToMove(board, row, col)) {
            board[row][col] = true;
            solve(board, knight - 1, row, col + 1);
            board[row][col] = false;
        }

        solve(board, knight, row, col + 1);

    }

    public static void kNight(boolean[][] board, int knight) {
        solve(board, knight, 0, 0);
    }

    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        for(boolean[] i : board) Arrays.fill(i, false);
        kNight(board, n);
    }
}
