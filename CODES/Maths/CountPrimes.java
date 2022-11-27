package Maths;


// this code will give TLE
public class CountPrimes {

    // TC o(sqrt(N))
    public static boolean isPrime(int n) {
        if(n <= 1) return false;

        int c = 2;
        while(c * c <= n) {
            if(n % c == 0) return false;
            c++;
        }

        return true;
    }

    // TC o(N)
    public static int countPrimes(int n) {
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime(i)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1));
    }
}
