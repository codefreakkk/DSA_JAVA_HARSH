package recursion.backtracking;

public class Knight {
    static void knight(boolean board[][], int row, int col, int knights) {
        if(knights == 0) {
            display(board);
            System.out.println();
            return;
        }
        if(row == board.length - 1 && col == board.length) {
            return;
        }
        if(col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }
        if(isSafeToMove(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        knight(board, row, col + 1, knights);
    }

    static void display(boolean board[][]) {
        for(boolean i[] : board) {
            for(boolean ans : i) {
                if(ans == true) {
                    System.out.print("K");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    static boolean isSafeToMove(boolean board[][], int row, int col) {
        if(checkIfIndexIsOutOfBound(board, row - 2, col - 1)) {
            if(board[row - 2][col - 1]) {
                return false;
            }
        }
        if(checkIfIndexIsOutOfBound(board, row - 2, col + 1)) {
            if(board[row][col]) {
                return false;
            }
        }
        if(checkIfIndexIsOutOfBound(board, row - 1, col - 2)) {
            if(board[row - 1][col - 1]) {
                return false;
            }
        }
        if(checkIfIndexIsOutOfBound(board, row - 1, col + 2)) {
            if(board[row + - 1][col + 2]) {
                return false;
            }
        }
        return true;
    }

    static boolean checkIfIndexIsOutOfBound(boolean board[][], int row, int col) {
        if((row >= 0 && row < board.length) && (col >=0 && col < board.length)) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        knight(new boolean[4][4], 0, 0, 4);
    }
}
