package Maths.Bitmanipulation;

public class MagicNumber {

    // returning answer in modulo 1e9 + 7
    public static long nthMagicNumber(int n) {
        if(n == 0) return 0;

        long power = 5;
        long ans = 0;

        int m = 1000000007;
        while(n > 0) {
            long last = n & 1;
            n >>= 1;
            ans += last * power;
            ans %= m;

            power *= 5;
            power %= m;
        }

        return ans % m;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(nthMagicNumber(n));
    }
}
