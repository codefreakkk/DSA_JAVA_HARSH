package recursion.LoveBabbarSheetRecursionBacktracking;

import java.util.Arrays;

//-----------------------------problem not solved--------------------------------

public class FindShortestSafestRouteInMatrix {
    public static boolean isValid(int[][] mat, int x, int y) {
        return (x >= 0 && y >= 0 ) && x < mat.length && y < mat[0].length;
    }

    public static boolean isSafeToMove(int[][] mat, int x, int y) {
        // check up
        if(isValid(mat, x - 1, y) && mat[x - 1][y] == 0) return true;

        // check left
        if(isValid(mat, x, y - 1) && mat[x][y - 1] == 0) return true;

        // check right
        if(isValid(mat, x, y + 1) && mat[x][y + 1] == 0) return true;

        // check down
        if(isValid(mat, x + 1, y) && mat[x + 1][y] == 0) return true;

        return false;
    }

    public static int solve(int[][] mat, int x, int y, int cnt) {
        if(isSafeToMove(mat, x, y) || x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || mat[x][y] == -1 || mat[x][y] == 0) {
            return Integer.MAX_VALUE;
        }

        if(y == mat[0].length - 1) return cnt;

        int value = mat[x][y];
        mat[x][y] = -1;
        int down = solve(mat, x + 1, y, cnt + 1);
        int right = solve(mat, x, y + 1, cnt + 1);
        int up = solve(mat, x - 1, y, cnt + 1);
        int left = solve(mat, x, y - 1, cnt + 1);
        mat[x][y] = value;

        return Arrays.stream(new int[]{down, right, up, left}).min().getAsInt();
    }

    public static int findShortestPath(int[][] mat) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < mat.length; i++) {
            if(!isSafeToMove(mat, i, 0)) {
                int length = solve(mat, i, 0, 0);
                ans = Math.min(ans, length);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1}
        };

        System.out.println(findShortestPath(mat));
    }
}
