package recursion.backtracking;

import java.util.ArrayList;

public class RatInaMaze {
    static boolean isSafeToMove(int x, int y, int n, int visited[][], int m[][]) {
        if((x >= 0 && x < n ) && (y >= 0 && y < n) && visited[x][y] == 0 && m[x][y] == 1) {
            return true;
        } else {
            return false;
        }
    }
    static void findAllPaths(int[][] m, ArrayList<String> answer, int x, int y, String path, int n, int[][] visited) {
        if(x == n - 1 && y == n - 1) {
            answer.add(path);
            return;
        }

        visited[x][y] = 1;
//        down
        int newx = x + 1;
        int newy = y;
        if(isSafeToMove(newx, newy, n, visited, m)) {
            findAllPaths(m, answer, newx, newy, path+"D", n, visited);
        }
//        left
        newx = x;
        newy = y - 1;
        if(isSafeToMove(newx, newy, n, visited, m)) {
            findAllPaths(m, answer, newx, newy, path+"L", n, visited);
        }
//        right
        newx = x;
        newy = y + 1;
        if(isSafeToMove(newx, newy, n, visited, m)) {
            findAllPaths(m, answer, newx, newy, path+"R", n, visited);
        }
//        up
        newx = x - 1;
        newy = y;
        if(isSafeToMove(newx, newy, n, visited, m)) {
            findAllPaths(m, answer, newx, newy, path+"U", n, visited);
        }
        visited[x][y] = 0;
    }
    static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> answer = new ArrayList<>();
        String path = "";
        int visited[][] = new int[n][n];
        findAllPaths(m, answer, 0, 0, path, n, visited);
        return answer;
    }
    public static void main(String[] args) {
        int [][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        ArrayList<String> answer = findPath(m, m.length);
        System.out.println(answer);
    }
}


