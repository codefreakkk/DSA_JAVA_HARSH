package Maths.Bitmanipulation;

public class BitOperation {
    public static int setBit(int n, int pos) {
        int mask = 1 << pos;
        n = n | mask;
        return n;
    }

    public static int getBit(int n, int pos) {
        return (n & (1 << pos - 1)) > 0 ? 1 : 0;
    }

    public static int clearBit(int n, int pos) {
        int mask = ~(1 << pos - 1);
        return n & mask;
    }

    public static void main(String[] args) {
        int n = 11;
        int pos = 2;
//        int ans = setBit(n, pos);
//        System.out.println(ans);

//        int ans = getBit(n, pos);
//        System.out.println(ans);

//        System.out.println(Integer.toBinaryString(n));
//        int ans = clearBit(n, pos);
//        System.out.println(Integer.toBinaryString(ans));
//        System.out.println(ans);
    }
}
