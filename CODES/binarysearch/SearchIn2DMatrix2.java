package binarysearch;

public class SearchIn2DMatrix2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // lower bound
        int start = 0;

        // upper bound
        int end = matrix[0].length - 1;

        while(start < matrix.length && end >= 0) {
            if(matrix[start][end] == target) return true;
            else if(matrix[start][end] > target) end--;
            else start++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 56}
        };

        int target = 104;
        boolean ans = searchMatrix(matrix, target);
        System.out.println(ans);
    }
}
