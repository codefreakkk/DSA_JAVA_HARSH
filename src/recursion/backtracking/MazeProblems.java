package recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeProblems {
    static int paths(int x, int y) {
        if(x == 1 || y == 1) {
            return 1;
        }
        int count = 0;
        count += paths(x - 1, y);
        count += paths(x, y - 1);
        return count;
    }
    static ArrayList<String> printPaths(String path, int x, int y) {
        if(x == 1 && y == 1) {
            ArrayList<String> output = new ArrayList<String>();
            output.add(path);
            return output;
        }
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
//        check if x > 1 and y > 1 because if x == 1 and y == 1 is not checked then the values might get negative
        if(x > 1) {
            left = printPaths(path + "D", x - 1, y);
        }
        if(y > 1) {
            right = printPaths(path + "R", x, y - 1);
        }
        left.addAll(right);
        return left;
    }

//    also can move diagonally
    static ArrayList<String> printPathsDiagonally(String path, int x, int y) {
        if(x == 1 && y == 1) {
            ArrayList<String> output = new ArrayList<String>();
            output.add(path);
            return output;
        }
        ArrayList<String> answer = new ArrayList<>();
    //        check if x > 1 and y > 1 because if x == 1 and y == 1 is not checked then the values might get negative
            if(x > 1 && y > 1) {
                answer.addAll(printPathsDiagonally(path + "D", x - 1, y - 1));
            }
            if(x > 1) {
                answer.addAll(printPathsDiagonally(path + "V", x - 1, y));
            }
            if(y > 1) {
                answer.addAll(printPathsDiagonally(path + "H", x, y - 1));
            }
            return answer;
    }
    static ArrayList<String> mazeWithObstacle(boolean maze[][], String path, int x, int y) {
        if(x == maze.length - 1 && y == maze[0].length - 1) {
            ArrayList<String> answer = new ArrayList<>();
            answer.add(path);
            return answer;
        }
        ArrayList<String> answer = new ArrayList<>();
        if(maze[x][y] != false && x < maze.length - 1) {
            answer.addAll(mazeWithObstacle(maze, path + "D",  x + 1, y));
        }
        if(maze[x][y] != false && y < maze[0].length - 1) {
            answer.addAll(mazeWithObstacle(maze, path + "R", x, y + 1));
        }
        return answer;
    }
//    maze without obstacle
    static ArrayList<String> mazeWithoutObstacleAllPath(boolean maze[][], String path, int x, int y) {
        if(x == maze.length - 1 && y == maze[0].length - 1) {
            ArrayList<String> answer = new ArrayList<>();
            answer.add(path);
            return answer;
        }
        ArrayList<String> answer = new ArrayList<>();
        if(maze[x][y] == false) {
            return answer;
        }
        maze[x][y] = false;
        if(x < maze.length - 1) {
            answer.addAll(mazeWithoutObstacleAllPath(maze, path + "D",  x + 1, y));
        }
        if(y < maze[0].length - 1) {
            answer.addAll(mazeWithoutObstacleAllPath(maze, path + "R", x, y + 1));
        }
        if(x > 0) {
            answer.addAll(mazeWithoutObstacleAllPath(maze, path + "U", x - 1, y));
        }
        if(y > 0) {
            answer.addAll(mazeWithoutObstacleAllPath(maze, path + "L", x, y - 1));
        }
//        backtracking
//        before the function gets removed also removed the changes that were made by that function at the time of recursion call
        maze[x][y] = true;
        return answer;
    }

//    print the path as well as level of recursion
static void mazeWithoutObstacleAllPathAndLevel(boolean maze[][], String path, int x, int y, int numericPath[][], int step) {
    if(x == maze.length - 1 && y == maze[0].length - 1) {
        numericPath[x][y] = step;
        for(int i[] : numericPath) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println(path);
        return;
    }
//    check if it is safe to move down, right, up, left (check via visited[][] array)
    if(maze[x][y] == false) {
        return;
    }
    numericPath[x][y] = step;
    maze[x][y] = false;
    if(x < maze.length - 1) {
        mazeWithoutObstacleAllPathAndLevel(maze, path + "D",  x + 1, y, numericPath, step + 1);
    }
    if(y < maze[0].length - 1) {
        mazeWithoutObstacleAllPathAndLevel(maze, path + "R", x, y + 1, numericPath, step + 1);
    }
    if(x > 0) {
        mazeWithoutObstacleAllPathAndLevel(maze, path + "U", x - 1, y, numericPath, step + 1);
    }
    if(y > 0) {
        mazeWithoutObstacleAllPathAndLevel(maze, path + "L", x, y - 1, numericPath, step + 1);
    }
//        backtracking
//        before the function gets removed also removed the changes that were made by that function at the time of recursion call
    maze[x][y] = true;
    numericPath[x][y] = 0;
    return;
}

    public static void main(String[] args) {
        boolean arr[][] = new boolean[2][2];
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = true;
            }
        }
//        arr[1][1] = false;
//        mazeWithoutObstacleAllPathAndLevel(arr, "", 0, 0, new int[arr.length][arr[0].length], 1);
        System.out.println(mazeWithoutObstacleAllPath(arr, "", 0, 0));
    }
}
