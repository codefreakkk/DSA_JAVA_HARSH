package REVISION.recursion;

import java.util.Arrays;

public class SelectionSortRecursion {

    public static void solve(int[] nums, int row, int col, int max) {
        if(row == 0) return;

        if(col < row) {
            if(nums[col] > nums[max]) max = col;
            solve(nums, row, col + 1, max);
        }
        else {
            // swap the largest element with last index
            int temp = nums[max];
            nums[max] = nums[row - 1];
            nums[row - 1] = temp;

            solve(nums, row - 1, 0, 0);
        }
    }

    public static void selectionSort(int[] nums) {
        solve(nums, nums.length, 0, 0);
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
