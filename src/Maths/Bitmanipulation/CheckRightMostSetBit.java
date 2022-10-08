package Maths.Bitmanipulation;

public class CheckRightMostSetBit {
    public static int rightMostSetBit(int n) {
        int position = 1;

        while(n > 0) {
            if((n &  1) > 0) return position;
            n >>= 1;
            position++;
        }

        return position;
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(rightMostSetBit(n));
    }
}
