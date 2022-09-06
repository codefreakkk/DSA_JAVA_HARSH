package sliding_window;

import java.util.ArrayList;

public class MaxSumSubarrayOfSizeK {
    public static long maximumSumSubarray(int k, ArrayList<Integer> arr, int n) {
        int i = 0, j = 0;
        long sum = 0;
        int maxi = Integer.MIN_VALUE;
        while(j < n) {
            sum += arr.get(j);
            if(j - i + 1  < k) j++;
            else if(j - i + 1 == k) {
                maxi = Integer.max(maxi,(int) sum);
                sum -= arr.get(i);
                i++;
                j++;
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int k = 2;
        int n = nums.size();

        System.out.println(maximumSumSubarray(k, nums, n));
    }
}
