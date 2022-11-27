package LinkedList;


public class ReverseLinkedListRecursion {

    public void reverse(Node node, Node head, Node tail) {
        if(node == tail) {
            head = tail;
            return;
        }
        
        reverse(node.next, head, tail);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation l = new SinglyLinkedListCreation();
        l.insertLast(10);
        l.insertLast(20);
        l.insertLast(30);
//        ReverseLinkedListRecursion obj = new ReverseLinkedListRecursion();
//        obj.reverse(l.head, l.head, l.tail);
//        System.out.println(l.head.value);
    }
}