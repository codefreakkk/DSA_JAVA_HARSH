package LinkedList.faraz;

public class ConvertBinaryInLLToInteger {
    public static int getDecimalValue(Node head) {
        if(head == null || head.next == null) return head.value;

        Node temp = head;
        int ans = temp.value;
        temp = temp.next;

        while(temp != null) {
            ans *= 2;
            ans += temp.value;
            temp = temp.next;
        }

        return ans;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(1);
        s.insertLast(1);

        System.out.println(getDecimalValue(s.head));
    }
}
