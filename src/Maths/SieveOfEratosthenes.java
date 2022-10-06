package Maths;

public class SieveOfEratosthenes {
    public static int sieve(int n, boolean[] nums) {
        for(int i = 2; i * i <= n; i++) {
            if(!nums[i]) {
                for(int j = i * 2; j <= n; j+=i) {
                    nums[j] = true;
                }
            }
        }

        int ans = 0;
        for(int i = 2; i <= n; i++) {
            if(!nums[i]) ans++;
        }

        return ans;
    }

    public static int countPrimes(int n) {
        int ans = sieve(n, new boolean[n + 1]);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(0));
    }
}
