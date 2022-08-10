package recursion.backtracking;

import java.util.*;

public class RatInAMazeStriver {
    static boolean isSafeToMove(int[][] maze, int[][] visited, int n, int x, int y) {
        if((x >= 0 && x < n) && (y >= 0 && y < n) && maze[x][y] == 1 && visited[x][y] == 0) {
            return true;
        }
        return false;
    }

    static void solve(int[][] maze, int[][] visited, int n, String path, int x, int y, List<String> answer) {
        if(x == n - 1 && y == n - 1) {
            answer.add(path);
            return;
        }

        visited[x][y] = 1;

        int newx = x + 1;
        int newy = y;
        if(isSafeToMove(maze, visited, n, newx, newy)) {
            solve(maze, visited, n, path + "D", newx, newy, answer);
        }

        newx = x;
        newy = y - 1;
        if(isSafeToMove(maze, visited, n,newx, newy)) {
            solve(maze, visited, n, path + "L", newx, newy, answer);
        }

        newx = x;
        newy = y + 1;
        if(isSafeToMove(maze, visited, n,newx, newy)) {
            solve(maze, visited, n, path + "R", newx, newy, answer);
        }

        newx = x - 1;
        newy = y;
        if(isSafeToMove(maze, visited, n, newx, newy)) {
            solve(maze, visited, n, path + "U", newx, newy, answer);
        }
//        backtrack
        visited[x][y] = 0;
    }

    static List<String> findPath(int[][] maze, int n) {
        List<String> answer = new ArrayList<>();
        int[][] visited = new int[n][n];
        solve(maze, visited, n, "", 0, 0, answer);
        return answer;
    }

    public static void main(String[] args) {
        int m[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};

        List<String> answer = findPath(m, m.length);
        for(String i : answer) {
            System.out.println(i);
        }
    }
}
