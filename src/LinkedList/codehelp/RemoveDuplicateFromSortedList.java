package LinkedList.codehelp;

public class RemoveDuplicateFromSortedList {
    public static Node deleteDuplicate(Node head) {
        if(head == null || head.next == null) return head;

        Node temp = head;
        while(temp.next != null) {
            if(temp.value == temp.next.value) {
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
