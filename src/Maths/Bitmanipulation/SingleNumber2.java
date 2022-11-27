package Maths.Bitmanipulation;

import java.util.Arrays;

public class SingleNumber2 {
    public static void storeInFrequency(int[] frequency, int n) {
        int i = 0;
        while(n > 0) {
            int num = frequency[i];
            frequency[i++] = num + (n & 1);
            n >>= 1;
        }
    }

    public static int singleNumber(int[] nums) {
        int size = nums.length;
        int[] frequency = new int[32];

        for(int i = 0; i < size; i++) {
            storeInFrequency(frequency, nums[i]);
        }

        int ans = 0;
        int pow = 0;
        for(int i : frequency)  {
            if(i % 3 > 0) ans += Math.pow(2, pow);
            pow++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 3};
        System.out.println(singleNumber(nums));
    }
}
