package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sort(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n - i; j++) {
                if(nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 10, 2, 1};
        sort(nums);
    }
}
