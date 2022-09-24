package LinkedList;

public class CircularSinglyLinkedListCreation {

    public Node head;
    public Node tail;
    public int size;

    public CircularSinglyLinkedListCreation() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    public Node getLastNode() {
        if(size == 1) return head;

        Node p = head;
        do {
            p = p.next;
        } while(p.next != head);

        return p;
    }
    public Node find(int index) {
        Node node = head;
        for(int i = 0; i < index; i++) node = node.next;
        return node;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // insert element at first with tail pointer
    public void insertFirst(int value) {
        Node node = new Node(value);

        if(head == null) {
            head = node;
            head.next = head;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        head = node;
        size++;
    }

    // insert element at first without using tail pointer
    public void insertFirstOofN(int value) {
        Node node = new Node(value);

        if(head == null) {
            head = node;
            head.next = head;
            tail = head;
            return;
        }

        // traverse to last element of list
        Node p = head;
        if(p.next != null) {
            do {
                p = p.next;
            } while(p.next != head);
        }

        p.next = node;
        node.next = head;
        head = node;
        size++;
    }


    //-------------delete---------------------


    // delete any index node
    public int delete(int index) {
        if(this.isEmpty()) return -1;

        // if one element is left
        if(size == 1) {
            int value = head.value;
            head = null;
            tail = null;
            size--;
            return value;
        }

        // if index entered is 0
        if(index == 0) {
            Node node = this.getLastNode();
            int value = head.value;
            head = head.next;
            node.next = head;
            size--;
            return value;
        }

        Node node = this.find(index - 1);
        int value = node.next.value;
        node.next = node.next.next;
        size--;
        return value;

    }

    // delete via value
    public int deleteByValue(int value) {
        if(this.isEmpty()) return -1;

        Node node = head;

        if(size == 1) {
            int val = head.value;
            head = null;
            tail = null;
            return value;
        }

        // if the given value is first element in list
        if(node.value == value) {
            int val = head.value;
            head = head.next;
            tail.next = head;
            return val;
        }

        Node p = head;
        boolean flag = false;
        do {
            p = node;
            node = node.next;
            if(value == node.value) {
                flag = true;
                break;
            }
        } while(node != head);

        if(flag) {
            int val = node.value;
            p.next = node.next;
            return val;
        }
        else return -1;
    }

    // display all elements of list
    public void display() {
        if(this.isEmpty()) {
            System.out.println("List empty");
            return;
        }

        Node p = head;
        if(head != null) {
            do {
                System.out.print(p.value + "->");
                p = p.next;
            } while(p != head);
        }

        System.out.print("HEAD");
        System.out.println();
    }


    // node structure
    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CircularSinglyLinkedListCreation cl = new CircularSinglyLinkedListCreation();
//        cl.insertFirst(10);
//        cl.insertFirst(20);
//        cl.insertFirst(30);
//        cl.insertFirst(40);
//        cl.display();

//        cl.insertFirstOofN(10);
//        cl.insertFirstOofN(20);
//        cl.insertFirstOofN(30);
//        cl.insertFirstOofN(40);
//        cl.display();
//        cl.deleteByValue(10);
//        cl.display();
    }
}
