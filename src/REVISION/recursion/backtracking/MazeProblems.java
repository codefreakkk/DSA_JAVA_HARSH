package REVISION.recursion.backtracking;

import java.util.*;

public class MazeProblems {
    public static int paths(int x, int y) {
        if(x == 1 || y == 1) {
            return 1;
        }

        int count = 0;
        count += paths(x - 1, y);
        count += paths(x, y - 1);
        return count;
    }

    // print paths
    public static List<String> printPaths(String path, int x, int y) {
        if(x == 1 && y == 1) {
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        List<String> down = new ArrayList<>();
        List<String> right = new ArrayList<>();

        // down
        if(x > 0) {
            down = printPaths(path + "D", x - 1, y);
        }

        // right
        if(y > 0) {
            right = printPaths(path + "R", x, y - 1);
        }

        down.addAll(right);
        return down;
    }

    // print paths diagonally
    public static List<String> printPathsDiagonally(String path, int x, int y) {
        if(x == 1 && y == 1) {
            List<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        List<String> answer = new ArrayList<>();

        if(x > 1 && y > 1) {
            answer.addAll(printPaths("D", x - 1, y - 1));
        }

        // down
        if(x > 1) {
            answer.addAll(printPaths(path + "V", x - 1, y));
        }

        // right
        if(y > 1) {
            answer.addAll(printPaths(path + "H", x, y - 1));
        }

        return answer;
    }

    // maze with obstacles
    public static void mazeWithObstacles(boolean[][] maze, String path, int x, int y) {
        if(x == maze.length - 1 && y == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        // down
        if(maze[x][y] && x < maze.length - 1) {
            mazeWithObstacles(maze, path + "D", x + 1, y);
        }

        // right
        if(maze[x][y] && y < maze[0].length - 1) {
            mazeWithObstacles(maze, path + "R", x, y + 1);
        }
    }

    // maze without obstacles
    public static void mazeWithoutObstacles(boolean[][] maze, String path, int x, int y) {
        if(x == maze.length - 1 && y == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if(!maze[x][y]) return;

        // visited this location
        maze[x][y] = false;
        // down
        if(x < maze.length - 1) mazeWithoutObstacles(maze, path + "D", x + 1, y);

        // right
        if(y < maze[0].length - 1) mazeWithoutObstacles(maze, path + "R", x, y + 1);

        // up
        if(x > 0) mazeWithoutObstacles(maze, path + "U", x - 1, y);

        // left
        if(y > 0) mazeWithoutObstacles(maze, path + "U", x, y - 1);

        // backtrack
        maze[x][y] = true;
    }

    public static void main(String[] args) {
//        System.out.println(paths(3, 3));
//        List<String> ans = printPaths("", 3, 3);
//        System.out.println(ans);
//     List<String> ans = printPathsDiagonally("", 3, 3);
//        System.out.println(ans);
        boolean[][] arr = new boolean[2][2];
        for(boolean[] a : arr) {
            Arrays.fill(a, true);
        }
        mazeWithoutObstacles(arr, "", 0, 0);
    }

}
