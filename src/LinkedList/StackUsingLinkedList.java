package LinkedList;

public class StackUsingLinkedList {
    Node head = null;

    public void push(int a) {
        Node node = new Node(a);
        node.next = head;
        head = node;
    }

    public  int pop() {
        if(head == null) return -1;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp.value;
    }

    public static void main(String[] args) {

    }
}
