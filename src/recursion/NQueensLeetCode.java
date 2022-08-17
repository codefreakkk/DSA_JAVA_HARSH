package recursion;

import java.util.*;
// leetcode problem
public class NQueensLeetCode {
    static boolean isSafeToMove(int n, int col, int row, char[][] board) {
        int duplicateCol = col;
        int duplicateRow = row;

        // check for upward diagonal
        while(col >= 0 && row >=0) {
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        // check for middle line
        col = duplicateCol;
        row = duplicateRow;
        while(col >= 0) {
            if(board[row][col] == 'Q') return false;
            col--;
        }
        // check for downward diagonal
        col = duplicateCol;
        row = duplicateRow;
        while(row < n && col >= 0) {
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    static void solve(int n, int col, char[][] board, List<List<String>> answer) {
        if(col == n) {
//            convert 2d char array into string and add it into list than add that list into 2d list
            List<String> lst = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                lst.add(new String(board[i]));
            }
            answer.add(lst);
            return;
        }

        for(int row = 0; row < n; row++) {
            if(isSafeToMove(n, col, row, board)) {
                board[row][col] = 'Q';
                solve(n, col + 1, board, answer);
                board[row][col] = '.';
            }
        }
    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
//      create 2d char[][] and fill that array with dor (.)
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(n, 0, board, answer);
        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> ans = solveNQueens(4);
        for(List<String> i : ans) {
            System.out.println(i);
        }
    }
}
