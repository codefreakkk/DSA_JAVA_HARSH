package recursion;

public class FloodFill {
    public static void solve(int[][] image, int x, int y, int color, int oldColor) {
        if(x < 0 || y < 0 || x == image.length || y == image[0].length || image[x][y] != oldColor || image[x][y] == color) {
            return;
        }
        image[x][y] = color;
        solve(image, x + 1, y, color, oldColor);
        solve(image, x, y - 1, color, oldColor);
        solve(image, x, y + 1, color, oldColor);
        solve(image, x - 1, y, color, oldColor);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] coloredImage = image;
        solve(image, sr, sc, color, image[sr][sc]);
        return coloredImage;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,1,1},{1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] answer = floodFill(nums, sr, sc, color);

        for(int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }
}