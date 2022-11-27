package LinkedList.striver;

public class AddTwoNumbers {
    public static Node addTwoNumbers(Node first, Node second) {
        Node head1 = first;
        Node head2 = second;

        Node ans = new Node(-1);
        Node ansHead = ans;

        int head1Value = 0;
        int head2Value = 0;
        int carry = 0;
        while(head1 != null || head2 != null) {
            // handle first list value
            if(head1 == null) head1Value = 0;
            else {
                head1Value = head1.value;
                head1 = head1.next;
            }

            // handle second list values
            if(head2 == null) head2Value = 0;
            else {
                head2Value = head2.value;
                head2 = head2.next;
            }

            // add the answer
            int sum = head1Value + head2Value + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ansHead.next = new Node(digit);
            ansHead = ansHead.next;
        }

        if(carry > 0) ansHead.next = new Node(carry);
        return ans.next;
    }

    public static void main(String[] args) {

    }
}
