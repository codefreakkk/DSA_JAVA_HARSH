package Maths;

public class Prime {
    public static boolean isPrime(int n) {
        if(n <= 1) return false;

        int c = 2;

        // iterate till square root of n
        while(c * c <= n) {
            if(n % c == 0) return false;
            c++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(10));
    }
}
