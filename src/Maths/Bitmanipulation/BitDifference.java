package Maths.Bitmanipulation;

// Q find the number of bits to change, to convert A to B
public class BitDifference {
    public static int countBitsFlip(int a, int b) {
        int xor = a ^ b;

        // count number of bits
        int count = 0;
        while(xor > 0) {
            xor = (xor & xor - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int a = 20;
        int b = 25;
        System.out.println(countBitsFlip(a, b));
    }
}
