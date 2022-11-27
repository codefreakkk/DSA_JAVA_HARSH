package REVISION.recursion.backtracking;

import java.util.*;

public class NQueens {
    public static boolean isSafeToMove(boolean[][] board, int n, int x, int y) {
        // for row
        int row = x;
        int col = y;
        while(col >= 0) {
            if(!board[row][col]) return false;
            col--;
        }

        // up diagonal
        row = x;
        col = y;
        while(col >= 0 && row >= 0) {
            if(!board[row][col]) return false;
            col--;
            row--;
        }

        // down diagonal
        row = x;
        col = y;
        while(col >= 0 && row < n) {
            if(!board[row][col]) return false;
            col--;
            row++;
        }

        return true;
    }

    public static void solve(boolean[][] board, int n, int col, ArrayList<Integer> output, ArrayList<ArrayList<Integer>> ans) {
        if(col == n) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isSafeToMove(board, n, i, col)) {
                board[i][col] = false;
                output.add(i + 1);
                solve(board, n, col + 1, output, ans);
                output.remove(output.size() - 1);
                board[i][col] = true;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];

        for(boolean[] i : board) Arrays.fill(i, true);
        solve(board, n, 0, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = nQueen(4);
        for(ArrayList<Integer> a : ans) System.out.println(a);
    }
}
