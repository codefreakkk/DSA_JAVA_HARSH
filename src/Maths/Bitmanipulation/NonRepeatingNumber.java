package Maths.Bitmanipulation;

// leetcode
//https://leetcode.com/problems/single-number-iii/

//gfg
//https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1

import java.util.Arrays;

public class NonRepeatingNumber {
    public static int getSetBitPosition(int n) {
        int position = 0;

        while(n > 0) {
            position++;
            n >>= 1;
        }

        return position;
    }

    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        int size = nums.length;

        // find xor of all numbers
        for(int i = 0; i < size; i++) xor ^= nums[i];

        // find set bit position
        int position = getSetBitPosition(xor);
        int setBit = 1 << position - 1;

        // find the answer via dividing them according their set bit
        int[] ans = new int[2];
        for(int n : nums) {
            if((n & setBit) == 0) ans[0] ^= n;
            else ans[1] ^= n;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        int[] ans =singleNumber(nums);
        System.out.println(Arrays.toString(ans));

    }
}
