package Maths.Bitmanipulation;

public class PowerOfB {
    public static int powerOfB(int n) {
        int power = 3;
        int base = 3;
        int ans = 1;

        while(power > 0) {
            if((power & 1) == 1) {
                ans *= base;
            }
            base *= base;
            power >>= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(powerOfB(3));
    }
}

