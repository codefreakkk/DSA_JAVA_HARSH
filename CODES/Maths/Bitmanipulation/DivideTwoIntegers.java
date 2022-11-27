package Maths.Bitmanipulation;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if(dividend == (1 << 31) && divisor == -1) return Integer.MAX_VALUE;

        boolean sign = (dividend >= 0) == (divisor >= 0) ? true : false;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        // double the divisor and check for ans
        int result = 0;
        while((dividend - divisor) >= 0) {
            int count = 0;
            while(dividend - (divisor << 1 << count) >= 0) count++;

            result += 1 << count;
            dividend -= divisor << count;
        }

        return sign ? result : -result;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        System.out.println(divide(dividend, divisor));
    }
}
