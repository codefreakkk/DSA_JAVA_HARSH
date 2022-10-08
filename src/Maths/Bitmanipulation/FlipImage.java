package Maths.Bitmanipulation;

public class FlipImage {
    public static int[][] flipAndInvertImage(int[][] image) {
        int m = image[0].length;

        for(int[] rows : image) {
            for(int i = 0; i < (m + 1) / 2; i++) {
                int temp = rows[i] ^ 1;
                rows[i] = rows[m - i - 1] ^ 1;
                rows[m - i - 1] = temp;
            }
        }

        return image;
    }

    public static void main(String[] args) {
    }
}
