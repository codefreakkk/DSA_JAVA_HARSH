package Maths.Bitmanipulation;

public class NumberOf1BitSet {
    public static int setBits(int n) {
        int count = 0;

        while(n > 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(setBits(n));
    }
}
