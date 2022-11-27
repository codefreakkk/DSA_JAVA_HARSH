package REVISION.recursion;

import java.util.Arrays;

public class BubbleSortRecursion {
    public static void bubbleSort(int[] nums, int row, int col) {
        if(row == 0) return;

        if(col < row) {
            if(nums[col] > nums[col + 1]) {
                int temp = nums[col];
                nums[col] = nums[col + 1];
                nums[col + 1] = temp;
            }
            bubbleSort(nums, row, col + 1);
        }
        else bubbleSort(nums, row - 1, 0);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 8, -1,  1};
        bubbleSort(nums, nums.length - 1, 0);
        System.out.println(Arrays.toString(nums));
    }
}
