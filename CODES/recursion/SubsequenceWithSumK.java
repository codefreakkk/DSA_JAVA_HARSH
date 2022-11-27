package recursion;

import java.util.ArrayList;

public class  SubsequenceWithSumK {
    static void printSubSequenceSum(int[] nums, int index, int sum, int k, ArrayList<Integer> output) {
        if(index >= nums.length) {
            if(sum == k) {
                System.out.println(output);
            }
            return;
        }
        output.add(nums[index]);
        printSubSequenceSum(nums, index + 1, sum + nums[index], k, output);
        output.remove(output.size() - 1);
        printSubSequenceSum(nums, index + 1, sum, k, output);
    }

//    function if you want only one answer to be printed
    static boolean printOnlyOneSubSequenceSum(int[] nums, int index, int sum, int k, ArrayList<Integer> output) {
        if(index >= nums.length) {
            if(sum == k) {
                System.out.println(output);
                return true;
            }
            return false;
        }
        output.add(nums[index]);
        if(printOnlyOneSubSequenceSum(nums, index + 1, sum + nums[index], k, output)) {
            return true;
        }
        output.remove(output.size() - 1);
        if(printOnlyOneSubSequenceSum(nums, index + 1, sum, k, output)) {
            return true;
        }
        return false;
    }

    static int countSubSequenceSum(int[] nums, int index, int sum, int k, ArrayList<Integer> output) {
        if(index >= nums.length) {
            if(sum == k) {
                return 1;
            }
            return 0;
        }
        output.add(nums[index]);
        int left = countSubSequenceSum(nums, index + 1, sum + nums[index], k, output);
        output.remove(output.size() - 1);
        int right = countSubSequenceSum(nums, index + 1, sum, k, output);
        return left + right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(countSubSequenceSum(nums, 0, 0, 4, new ArrayList<Integer>()));
    }
}
