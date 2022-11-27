package Maths.Bitmanipulation;

public class MinimumBitFlipToConvertNumber {
    public static int minBitFlip(int start, int goal) {
        int xor = start ^ goal;

        int count = 0;
        while(xor > 0) {
            if((xor & 1) == 1) count++;
            xor >>= 1;
        }

        return count;
    }
    public static void main(String[] args) {

    }
}
