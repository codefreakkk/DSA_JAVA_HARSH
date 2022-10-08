package Maths.Bitmanipulation;

public class XorOfNumbersFrom0ToN {
    public static int xorOfRange(int n) {
        if(n % 4 == 0) return n;
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n + 1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(xorOfRange(5));
    }
}
