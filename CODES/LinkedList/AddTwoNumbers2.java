package LinkedList;

public class AddTwoNumbers2 {
    public static Node reverse(Node head) {
        Node prev = null;
        Node present = head;
        Node nxt = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = nxt;
            if(nxt != null) nxt = nxt.next;
        }

        return prev;
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node newList1 = reverse(l1);
        Node newList2 = reverse(l2);

        Node ans = new Node(-1), ansHead = ans;

        int carry = 0;
        while(newList1 != null || newList2 != null) {
            int value1 = 0;
            int value2 = 0;

            if(newList1 != null) value1 = newList1.value;
            if(newList2 != null) value2 = newList2.value;

            int sum = value1 + value2 + carry;

            int digit = sum % 10;
            carry = sum / 10;
            ansHead.next = new Node(digit);
            ansHead = ansHead.next;

            if(newList1 != null) newList1 = newList1.next;
            if(newList2 != null) newList2 = newList2.next;
        }

        if(carry > 0) ansHead.next = new Node(carry);

        ans = reverse(ans.next);
        return ans;
    }

    public static void main(String[] args) {

    }
}
