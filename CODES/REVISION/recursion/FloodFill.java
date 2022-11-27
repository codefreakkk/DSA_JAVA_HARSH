package REVISION.recursion;

public class FloodFill {
    public static void solve(int[][] image, int x, int y, int color, int oldColor) {
        if(x < 0 || y < 0 || x == image.length || y == image[0].length || image[x][y] == color || image[x][y] != oldColor) {
            return;
        }

        image[x][y] = color;
        solve(image, x + 1, y, color, oldColor);
        solve(image, x, y + 1, color, oldColor);
        solve(image, x - 1, y, color, oldColor);
        solve(image, x , y - 1, color, oldColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        solve(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {

    }
}
