package LinkedList;

public class DoublyLinkedListCreation {
    private class Node {
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
   public Node head = null;
   public Node tail = null;
   public int size = 0;

   public boolean isEmpty() {
       return head == null;
   }

   // insert value at first
   public void insertFirst(int value) {
       Node node = new Node(value);

       node.next = head;
       node.prev = null;
       if(head != null) head.prev = node;
       if(tail == null) tail = head;
       head = node;

       size++;
   }

   // insert value at end
   public void insertLast(int value) {
       Node node = new Node(value);

       // if list is empty add a node first
       if(head == null) {
           node.prev = null;
           node.next = head;
           head = node;
           tail = head;
           size++;
           return;
       }

       // if list has some elements
       node.next = null;
       tail.next = node;
       node.prev = tail;
       tail = node;
       size++;
   }

   // insert node after a given node
   public void insertAfter(int after, int value) {
       if(this.isEmpty()) {
           System.out.println("List empty");
           return;
       }

       // find the given node position
       Node p = head;
       while(p != null && p.value != after) {
           p = p.next;
       }

       // if no element found
       if(p == null) {
           System.out.println("Given Element not found");
           return;
       }

       Node node = new Node(value);
       node.next = p.next;
       p.next = node;
       node.prev = p;
       if(node.next != null) {
           node.next.prev = node;
       }

       size++;
   }

   //-----------------------delete------------------------------


    // delete first element from list
    public int deleteFirst() {
       if(this.isEmpty()) return -1;

       int value = head.value;
       head = head.next;
       size--;

       if(head == null) tail = null;
       return value;
    }

    // delete last element from list
    public int deleteLast() {
       if(this.isEmpty()) return -1;

       // if only one element is present in list
       if(head.next == null) {
           int value = head.value;
           head = null;
           tail = null;
           return value;
       }

       int value = tail.prev.value;
       tail.prev.next = null;
       size--;
       return value;
    }

    // delete specific index element from list
    public int delete(int index) {
        if(this.isEmpty()) return -1;

        if(size == 1) {
            size--;
            return deleteFirst();
        }

        Node p = head;
        for(int i = 0; i < index - 1; i++) {
            // if index is greater than size of list
            if(p == null) {
                size--;
                return deleteLast();
            }
            p = p.next;
        }

        // if list size is greater than 1
        int value = p.next.value;
        p.next = p.next.next;
        size--;
        return value;
    }

   // display serial
   public void display() {
       Node temp = head;

       if(temp == null) {
           System.out.println("List empty");
           return;
       }

       while(temp != null) {
           System.out.print(temp.value + "->");
           temp = temp.next;
       }

       System.out.print("END");
       System.out.println();
   }

   // display in reverse order
   public void displayReverse() {
       Node temp = tail;

       if(tail == null) {
           System.out.println("List empty");
           return;
       }

       while(temp != null) {
           System.out.print(temp.value + "->");
           temp = temp.prev;
       }

       System.out.print("START");
       System.out.println();
   }

    public static void main(String[] args) {
        DoublyLinkedListCreation dl = new DoublyLinkedListCreation();
//        dl.insertFirst(10);
//        dl.insertFirst(20);
//        dl.insertFirst(30);
//        dl.display();
//        System.out.println();
//        dl.displayReverse();

//        dl.insertLast(10);
//        dl.insertLast(20);
//        dl.insertLast(30);
//        dl.insertFirst(500);
//        dl.display();
//        dl.displayReverse();

//        dl.insertLast(10);
//        dl.insertLast(20);
//        dl.insertLast(30);
//        dl.insertLast(40);
//        dl.insertAfter(10, 500);
//        dl.display();

//        dl.insertLast(10);
//        dl.insertLast(20);
//        dl.insertLast(30);
//        dl.insertLast(40);
//        dl.display();
//        System.out.println(dl.deleteLast());
//        dl.display();

//        dl.insertLast(10);
//        dl.insertLast(20);
//        dl.insertLast(30);
//        dl.display();
//        dl.delete(1);
//        dl.delete(1);
//        dl.delete(1);
//        dl.display();
    }
}
