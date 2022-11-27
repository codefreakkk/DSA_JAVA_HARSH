package Maths;

public class BinaryExponentiation {
    public static long fastPower(long a, long b, int m) {
        long result = 1;

        while(b > 0) {
            // if b is odd append 'a' to answer
            if(b % 2 != 0) {
                result = (result % m *  a % m) % m;
            }
            // if b is even multiply itself
            a = (a % m * a % m) % m;
            b /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fastPower(2, 5, 1000000007));
    }
}
