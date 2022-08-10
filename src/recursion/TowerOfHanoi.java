package recursion;

public class TowerOfHanoi {
    static int solve(int N, int source, int destination, int helper) {
        int count = 0;
        count++;
        if(N == 1) {
            System.out.println("move disk "+N+" from rod "+source+" to rod "+destination);
            return 1;
        }
        count += solve(N - 1, source, helper, destination);
        System.out.println("move disk "+N+" from rod "+source+" to rod "+destination);
                count += solve(N - 1, helper, destination, source);
        return count;
    }

    static int toh(int N, int source, int destination, int helper) {
        return solve(N, source, destination, helper);
    }

    public static void main(String[] args) {
        System.out.println(toh(2, 1, 3, 2));
    }
}
