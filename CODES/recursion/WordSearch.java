package recursion;

public class WordSearch {
    public static boolean search(char[][] board, String word, int index, int x, int y) {
        if(index == word.length()) return true;
        if((x < 0 || y < 0 || x == board.length || y == board[0].length) || board[x][y] != word.charAt(index)) return false;

        board[x][y] = '#';
        boolean down = search(board, word, index + 1, x + 1, y);
        boolean right = search(board, word, index + 1, x, y + 1);
        boolean up = search(board, word, index + 1, x - 1, y);
        boolean left = search(board, word, index + 1, x, y - 1);
        board[x][y] = word.charAt(index);

        return down || right || up || left;
    }

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
}