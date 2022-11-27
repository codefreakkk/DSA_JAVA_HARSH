package LinkedList.structure;


public class LL {
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
    public void insertLast(int value) {
        Node node = new Node(value);
        // if no element in array
        if(tail == null) {
            this.insertFirst(value);
            return;
        }

        // if there are elements in array
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
