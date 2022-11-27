package LinkedList;

public class MultiplyTwoLinkedList {
    public static long multiplyTwoLinkedList(Node l1, Node l2) {
        long ans1 = 0;
        long ans2 = 0;
//        int mod = 1000000007;
        int mod = (int) 10e9+7;
        while(l1 != null) {
            ans1 = ((ans1 % mod) * (10 % mod) % mod + l1.value % mod) % mod;
            l1 = l1.next;
        }

        while(l2 != null) {
            ans2 = ((ans2 % mod) * (10 % mod) % mod + l2.value % mod) % mod;
            l2 = l2.next;
        }

        return (ans1 % mod * ans2 % mod) % mod;
    }

    public static void main(String[] args) {

    }
}
