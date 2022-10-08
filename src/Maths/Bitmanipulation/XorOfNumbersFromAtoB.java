package Maths.Bitmanipulation;

public class XorOfNumbersFromAtoB {
    public static int xor(int n) {
        if(n % 4 == 0) return n;
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n + 1;
        return 0;
    }

    public static int getRangeXor(int a, int b) {
        int ans = xor(b) ^ xor(a - 1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getRangeXor(3, 9));
    }
}
