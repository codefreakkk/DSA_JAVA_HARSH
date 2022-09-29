package LinkedList.faraz;

public class CloneLinkedListWithRandomPointerNO_EXTRA_SPACE {
    public static Node cloneList(Node head) {
        if(head == null) return head;

        // make clone list
        Node clone = new Node(-1), cloneHead = clone;
        Node originalHead = head;
        while(originalHead != null) {
            cloneHead.next = new Node(originalHead.value);
            cloneHead = cloneHead.next;
            originalHead = originalHead.next;
        }

        // map the connections with clone list
        cloneHead = clone.next;
        originalHead = head;
        while(cloneHead != null && originalHead != null) {
            Node next = originalHead.next;
            originalHead.next = cloneHead;
            originalHead = next;

            next = cloneHead.next;
            cloneHead.next = originalHead;
            cloneHead = next;
        }

        // connect random pointer
        Node temp = head;
        while(temp != null) {
            if(temp.next != null && temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // reset the connections
        cloneHead = clone.next;
        originalHead = head;
        while(originalHead != null && cloneHead != null) {
            originalHead.next = cloneHead.next;
            originalHead = originalHead.next;

            if(originalHead != null) {
                cloneHead.next = originalHead.next;
            }
            cloneHead = cloneHead.next;
        }

        return clone.next;
    }

    public static void main(String[] args) {

    }
}
