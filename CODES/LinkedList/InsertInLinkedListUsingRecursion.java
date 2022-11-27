package LinkedList;

import LinkedList.SinglyLinkedListCreation.*;

public class InsertInLinkedListUsingRecursion extends SinglyLinkedListCreation {

    public void insertUsingRecursion(int index, int value) {
        head = insertR(value, index, head);
    }

    public Node insertR(int value, int index, Node node) {
        if(index == 0) {
            Node temp = new Node(value);
            temp.next = node;
            return temp;
        }

        Node n = insertR(value, index - 1, node.next);
        node.next = n;
        return node;
    }

    public static void main(String[] args) {
        InsertInLinkedListUsingRecursion ll = new InsertInLinkedListUsingRecursion();
        ll.insertLast(10);
        ll.insertLast(20);
        ll.insertLast(30);
        ll.insertLast(40);
        ll.insertUsingRecursion(0, 69);
        ll.display();
    }
}
