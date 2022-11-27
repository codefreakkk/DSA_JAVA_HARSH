package Maths.Bitmanipulation;

import java.util.Arrays;

public class FindRepeatingAndMissingNumber {
    public static int getSetBitPosition(int num) {
        int count = 0;
        int setBit = 0;
        while(setBit != 1) {
            setBit = num & 1;
            num = num >> 1;
            count++;
        }
        return count - 1;
    }

    public static boolean isRightBitSet(int num, int position) {
        if((num & (1 << position)) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] findTwoElements(int[] nums, int n) {
        int size = n;

        // xor array of nums
        int x = 0;
        for(int i = 0; i < size; i++) x ^= nums[i];

        // xor from 1 to n
        int y = 0;
        for(int i = 1; i <= size; i++) y ^= i;

        int num = x ^ y;
        int position = getSetBitPosition(num);

        // divide into bucket
        int bucket1 = 0;
        int bucket2 = 0;
        for(int i = 0; i < size; i++) {
            if(isRightBitSet(nums[i], position)) {
                bucket1 ^= nums[i];
            }
            else bucket2 ^= nums[i];
        }

        // xor buckets from 1 to n
        for(int i = 1; i <= size; i++) {
            if(isRightBitSet(i, position)) {
                bucket1 ^= i;
            }
            else bucket2 ^= i;
        }

        // get answer by comparing elements
        int repeating = -1;
        int missing = -1;
        for(int i = 0; i < size; i++) {
            if(bucket1 == nums[i]) {
                repeating = bucket1;
                missing = bucket2;
                break;
            }
            if(bucket2 == nums[i]) {
                repeating = bucket2;
                missing = bucket1;
                break;
            }
        }

        return new int[] {repeating, missing};
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 2, 1, 1};
        int[] ans = findTwoElements(nums, nums.length);
        System.out.println(Arrays.toString(ans));
    }
}
