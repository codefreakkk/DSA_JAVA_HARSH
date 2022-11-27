package Maths;

public class LCM {
    public static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 8;
        System.out.println(lcm(a, b));
    }
}
