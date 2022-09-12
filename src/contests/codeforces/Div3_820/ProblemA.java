package contests.codeforces.Div3_820;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        int t = 0;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while(t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int a1 = Math.abs(b - c) + Math.abs(c - 1);
            int a2 = Math.abs(a - 1);

            if(a1 > a2) System.out.println(1);
            else if(a1 < a2) System.out.println(2);
            else System.out.println(3);
        }
    }
}
