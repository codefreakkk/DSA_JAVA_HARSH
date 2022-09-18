package REVISION.recursion;

import java.util.*;

public class MergeSort {
    public static void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;

        int[] ans = new int[high - low + 1];

        while(i <= mid && j <= high) {
            if(nums[j] > nums[i]) {
                ans[k++] = nums[i++];
            } else {
                ans[k++] = nums[j++];
            }
        }

        while(i <= mid) {
            ans[k++] = nums[i++];
        }

        while(j <= high) {
            ans[k++] = nums[j++];
        }

        for(int p = 0, start = low; p < ans.length; p++, start++) {
            nums[start] = ans[p];
        }
    }

    public static void solve(int[] nums, int low, int high) {
        if(low >= high) return;

        int mid = (low + high) / 2;

        solve(nums, low, mid);
        solve(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public static void mergeSort(int[] nums) {
        int low = 0, high = nums.length - 1;
        solve(nums, low, high);
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1, -1, 3, -2};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
