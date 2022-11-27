package recursion.backtracking;

import java.util.*;

public class NQueensGFG {
    public static boolean isSafeToMove(int n, int row, int col, boolean[][] board) {
        int temprow = row;
        int tempcol = col;

        while(col >= 0) {
            if(board[row][col] == true) return false;
            col--;
        }

        row = temprow;
        col = tempcol;
        while(row >= 0 && col >= 0) {
            if(board[row][col] == true) return false;
            row--;
            col--;
        }

        row = temprow;
        col = tempcol;
        while(row < n && col >= 0) {
            if(board[row][col] == true) return false;
            row++;
            col--;
        }
        return true;
    }

    public static void solve(int n, int col, boolean[][] board, ArrayList<Integer> output, ArrayList<ArrayList<Integer>> answer) {
        if(col == n) {
            answer.add(new ArrayList<>(output));
            return;
        }

        for(int row = 0; row < n; row++) {
            if(isSafeToMove(n, row, col, board)) {
                board[row][col] = true;
                output.add(row + 1);
                solve(n, col + 1, board, output, answer);
                board[row][col] = false;
                output.remove(output.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        boolean[][] board = new boolean[n][n];
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], false);
        }
        solve(n, 0, board, new ArrayList<Integer>(), answer);
        return answer;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> answer = nQueen(4);
        for(ArrayList<Integer> i : answer) {
            System.out.println(i);
        }
    }
}