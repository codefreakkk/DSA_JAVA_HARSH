package LinkedList;

public class CircularDoublyLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public CircularDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;

    }

    // insert element at first
    public void insertFirst(int value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
            head.next = head;
            head.prev = head;
            tail = head;
            size++;
            return;
        }

        node.next = head;
        tail.next = node;
        head.prev = node;
        node.prev = tail;
        head = node;
        size++;
    }

    // insert element at end
    public void insertLast(int value) {
        if(head == null) {
            this.insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        node.next = head;
        head.prev = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    //------------delete---------------

    // delete first element in list
    public int deleteFirst() {
        if(this.isEmpty()) {
            System.out.println("List empty");
            return -1;
        }

        if(size == 1) {
            int value = head.value;
            head = null;
            tail = null;
            size--;
            return value;
        }

        int value = head.value;
        head = head.next;
        tail.next = head;
        head.prev = tail;
        size--;
        return value;
    }

    // delete last element in list
    public int deleteLast() {
        if(this.isEmpty()) {
            System.out.println("List empty");
            return -1;
        }

        // if there is only one element in list
        if(size == 1) {
            int value = head.value;
            head = null;
            tail = null;
            size--;
            return value;
        }

        Node p = head;
        while(p.next != tail) {
            p = p.next;
        }

        int value = tail.value;
        p.next = head;
        head.prev = p;
        tail = p;
        size--;
        return value;
    }

    // display all elements in list
    public void display() {
        if(this.isEmpty()) {
            System.out.println("List empty");
            return;
        }

        Node p = head;
        do {
            System.out.print(p.value + "->");
            p = p.next;
        } while(p != head);

        System.out.print("HEAD");
        System.out.println();
    }


    // linked list structure
    class Node {
        public int value;
        public Node next;
        public Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList cdl = new CircularDoublyLinkedList();
//        cdl.insertFirst(10);
//        cdl.insertFirst(20);
//        cdl.insertFirst(30);
//        cdl.insertFirst(40);
//        cdl.insertLast(30);
//        cdl.insertLast(40);
//        cdl.insertLast(50);
//        cdl.insertLast(60);
//        cdl.deleteFirst();
//        cdl.display();

        cdl.insertLast(30);
        cdl.insertLast(40);
        cdl.insertLast(50);
        cdl.insertLast(60);
        cdl.deleteLast();
        cdl.deleteLast();
        cdl.display();
    }
}
