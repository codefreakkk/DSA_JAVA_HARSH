package LinkedList;

import LinkedList.structure.*;

public class BubbleSortLinkedList {
    public Node get(Node head, int index) {
        Node p = head;
        for(int i = 0; i < index; i++) p = p.next;

        return p;
    }
    public void bubble(Node head, Node tail, int row, int col) {
        if(row == 0) return;

        if(col < row) {
            Node first = get(head, col);
            Node second = get(head,col + 1);
            if(first.value > second.value) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    tail = first;
                    Node prev = get(head, col - 1);
                    prev.next = second;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(head, col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubble(head, tail, row, col + 1);
        }
        else bubble(head, tail, row - 1, 0);
    }

    public void bubbleSort(Node head, Node tail, int size) {
        bubble(head, tail, size - 1,  0);
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation l = new SinglyLinkedListCreation();
        l.insertLast(4);
        l.insertLast(2);
        l.insertLast(1);
        l.insertLast(3);
        BubbleSortLinkedList b = new BubbleSortLinkedList();
        b.bubbleSort(l.head, l.tail, l.size);
        l.display();

    }
}
