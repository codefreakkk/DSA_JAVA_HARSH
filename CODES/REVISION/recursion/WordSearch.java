package REVISION.recursion;

public class WordSearch {
    public static boolean solve(char[][] board, String word, int x, int y, int index) {
        if(index == word.length()) return true;
        if((x < 0 || y < 0 || x == board.length || y == board[0].length) || board[x][y] != word.charAt(index)) return false;
        // check all 4 directions using recursion
        board[x][y] = '#';
        boolean down = solve(board, word, x + 1, y, index + 1);
        boolean right = solve(board, word, x, y + 1, index + 1);
        boolean up = solve(board, word, x - 1, y, index + 1);
        boolean left = solve(board, word, x, y - 1, index + 1);
        board[x][y] = word.charAt(index);

        return down || right || up || left;
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(solve(board, word, i, j, 0)) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
