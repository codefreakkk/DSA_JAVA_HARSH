package sorting;

import java.util.*;

public class FindAllNumbersDisappearedInArray {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<Integer> findDisappearedNumber(int[] nums) {
        int size = nums.length;
        int i = 0;
        List<Integer> ans = new ArrayList<>();

        // sort the array using cyclic sort
        while(i < size) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else i++;
        }

        // check for missing numbers
        for(int j = 0; j < size; j++) {
            if(nums[j] != j + 1) {
                ans.add(j + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDisappearedNumber(nums);
        System.out.println(ans);
    }
}
