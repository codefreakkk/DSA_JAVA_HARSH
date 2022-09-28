package LinkedList.faraz;

class Node {
    public int value;
    public Node next;
    public Node random;
    public Node bottom;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class SinglyLinkedListCreation {


    public Node head = null;
    public Node tail = null;
    public int size = 0;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }

        size += 1;
    }

    // insert at last in o(1) time
    public void insertLast(int value) {
        Node node = new Node(value);
        // if no element in array
        if(tail == null) {
//            node.next = head;
//            head = node;
//            tail = head;
//            size += 1;

            // instead you can call this function
            this.insertFirst(value);
            return;
        }

        // if there are elements in array
        tail.next = node;
        tail = node;
        size += 1;
    }

    // insert at last in o(n) time
    public void insertLastInOofN(int value) {
        if(head == null) {
            this.insertFirst(value);
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        Node node = new Node(value);
        temp.next = node;
    }

    // insert at any position
    public void insert(int value, int index) {
        if(index == 0) {
            insertFirst(value);
            return;
        }
        if(index >= size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for(int i = 0; i < index - 1; i++) temp = temp.next;

        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
    }

    //----------------delete--------------------------

    // delete first node
    public int deleteFirst() {
        if(head == null) return -1;

        int value = head.value;
        head = head.next;
        size--;

        if(head == null) tail = null;
        return value;
    }

    // delete last node
    public int deleteLast() {
        if(head == null) return -1;
        if(size == 1) return deleteFirst();

        Node temp = get(size - 2);

        int value = tail.value;
        tail = temp;
        tail.next = null;
        size--;
        return value;
    }

    // delete at any position
    public int delete(int index) {
         if(head == null) return -1;

         if(index == 0) return deleteFirst();
         if(index >= size - 1) return deleteLast();

         Node node = get(index - 1);
         int value = node.value;
         node.next = node.next.next;
         size--;
         return value;
    }

    // reverse ll using recursion
    public void reverse(Node node) {
        if(node == tail) {
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }


    // get pointer at specific index
    public Node get(int index) {
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }
    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void display(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation ll = new SinglyLinkedListCreation();
//        ll.insertFirst(10);
//        ll.insertFirst(20);
//        ll.insertFirst(30);
//        ll.display();
//        System.out.println(ll.size);
//        System.out.println(ll.tail.value);

//        ll.insertLast(10);
//        ll.insertLast(20);
//        ll.insertLast(30);
//        ll.insertFirst(200);
//        ll.display();

//        ll.insertLastInOofN(10);
//        ll.insertLastInOofN(20);
//        ll.insertLastInOofN(30);
//        ll.insertLastInOofN(30);
//        ll.display();

        ll.insertLast(10);
        ll.insertLast(20);
        ll.insertLast(30);
        ll.insertLast(40);
        ll.insertLast(50);
//        ll.insert(500, 4);

//        ll.display();
//        System.out.println("Deleted " + ll.deleteFirst());
//        ll.display();

//        ll.deleteLast();
//        ll.display();

//        ll.delete(60);
//        ll.display();


        ll.display();
        ll.reverse(ll.head);
        ll.display();
    }
}
