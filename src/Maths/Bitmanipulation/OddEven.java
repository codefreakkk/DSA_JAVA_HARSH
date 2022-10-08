package Maths.Bitmanipulation;

public class OddEven {
    public static void main(String[] args) {
        int n = 14;
        int ans = n & 1;
        if(ans > 0) System.out.println("odd");
        else System.out.println("even");
    }
}
