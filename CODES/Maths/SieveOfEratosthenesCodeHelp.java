package Maths;

import java.util.Arrays;

public class SieveOfEratosthenesCodeHelp {
    public static int sieve(int n) {
        boolean[] nums = new boolean[n];
        Arrays.fill(nums, true);
        int count = 0;

        for(int i = 2; i < n; i++) {

            // check if current number is prime
            if(nums[i]) {
                count++;

                // mark all the factors of i as false
                for(int j = i * 2; j < n; j+=i) {
                    nums[j] = false;
                }
            }
        }

        return count;
    }

    public static int countPrimes(int n) {
        return sieve(n);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
}
