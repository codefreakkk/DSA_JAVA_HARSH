package Maths.Bitmanipulation;

import java.util.Arrays;

public class TwoNumbersWithOddOccurrence {
    public static int getBitPosition(int num) {
        int position = 0;
        while((num & 1) != 1) {
            position++;
            num >>= 1;
        }

        return position;
    }

    public static int[] twoOddNum(int[] nums) {
        int size = nums.length;

        // xor all numbers in array
        int xor = 0;
        for(int i = 0; i < size; i++) xor ^= nums[i];

        int position = getBitPosition(xor);
        // divide into buckets
        int bucket1 = 0;
        int bucket2 = 0;
        for(int i = 0; i < size; i++) {
            if((nums[i] & (1 << position)) == 0) {
                bucket1 ^= nums[i];
            }
            else bucket2 ^= nums[i];
        }

        return new int[] {bucket1, bucket2};
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 5, 2, 3, 3, 1};
        int[] ans = twoOddNum(nums);
        System.out.println(Arrays.toString(ans));
    }
}
