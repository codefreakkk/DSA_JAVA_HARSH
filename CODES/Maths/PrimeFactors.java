package Maths;

import java.util.*;

public class PrimeFactors {
    public static int[] allPrimeFactor(int n) {
        boolean[] nums = new boolean[n];
        Arrays.fill(nums, true);
        List<Integer>  ans = new ArrayList<>();

        // get all prime numbers
        for(int i = 2; i < n; i++) {
            if(nums[i]) {
                if(n % i == 0) ans.add(i);
                // mark all the factors as false
                for(int j = i * 2; j < n; j += i) nums[j] = false;
            }
        }

        int[] answer = ans.stream().mapToInt(i->i).toArray();
        if(answer.length == 0 && n != 1) return new int[]{n};

        return answer;
    }

    public static void main(String[] args) {
        int num = 100;
        int[] ans = allPrimeFactor(num);
        System.out.println(Arrays.toString(ans));
    }
}
