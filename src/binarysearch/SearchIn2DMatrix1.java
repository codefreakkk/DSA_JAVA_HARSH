package binarysearch;

public class SearchIn2DMatrix1 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        int m = matrix[0].length;

        while(start <= end) {
            int mid = (start + end) >> 1;
            int value = matrix[mid / m][mid % m];
            if(target == value) return true;
            if(target < value) end = mid - 1;
            else start = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},
        };

        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
}
