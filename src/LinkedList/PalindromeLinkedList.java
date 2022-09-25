package LinkedList;

public class PalindromeLinkedList {
    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;
        StringBuilder ans = new StringBuilder();

        Node p = head;
        while(p != null) {
            ans.append(p.value);
            p = p.next;
        }

        String dummy = ans.toString();
        return ans.reverse().toString().equals(dummy);
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(1);
//        s.insertLast(1);

        System.out.println(isPalindrome(s.head));
    }
}
