package Maths;

public class Factors {

    // print the fact / divisor of number
    public static void fact(int n) {
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                System.out.println(i);

                // avoid duplicate number
                if(i != n / i) System.out.println(n / i);
            }
        }
    }

    // count the fact / divisor of a number
    public static int countFact(int n) {
        int count = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                count++;

                // avoid duplicate number
                if(i != n / i) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(countFact(n));
    }
}
