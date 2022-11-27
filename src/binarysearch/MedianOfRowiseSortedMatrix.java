package binarysearch;

public class MedianOfRowiseSortedMatrix {
    public static int countSmallerElements(int[] nums, int m) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] <= m) start = mid + 1;
            else end =  mid - 1;
        }

        return start;
    }

    public static int findMedian(int[][] matrix) {
        int start = 0;
        int end = (int) 1e9;

        int n = matrix.length;
        int m = matrix[0].length;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            // find elements <= mid
            int count = 0;
            for(int i = 0; i < n; i++) {
                count += countSmallerElements(matrix[i], mid);
            }

            int midOfMat = (n * m) / 2;
            if(count <= midOfMat) start = mid + 1;
            else end = mid - 1;
        }

        return start;
    }

    public static void main(String[] args) {
        int[][] nums = {
            {1, 3, 6},
            {2, 6, 9},
                {3, 6, 9}
        };
        System.out.println(findMedian(nums));
    }
}
