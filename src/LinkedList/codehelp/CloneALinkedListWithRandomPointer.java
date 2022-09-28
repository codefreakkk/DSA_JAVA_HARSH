package LinkedList.codehelp;

import java.util.HashMap;

public class CloneALinkedListWithRandomPointer {
    // TC - o(N), SC - o(N)
    // solution using map not much efficient as it uses map
    public static Node copyList1(Node head) {
        Node clone = new Node(-1);
        Node cloneHead = clone;
        Node cloneTemp = clone;

        HashMap<Node, Node> map = new HashMap<>();

        // clone list without random pointer
        Node temp = head;
        while(temp != null) {
            cloneTemp.next = new Node(temp.value);
            temp = temp.next;
            cloneTemp = cloneTemp.next;
        }

        // map the original node with clone node
        cloneTemp = cloneHead.next;
        Node originalTemp = head;
        while(originalTemp != null) {
            map.put(originalTemp, cloneTemp);
            cloneTemp = cloneTemp.next;
            originalTemp = originalTemp.next;
        }

        // connect random pointer
        originalTemp = head;
        cloneTemp = cloneHead.next;
        while(originalTemp != null) {
            cloneTemp.random = map.get(originalTemp.random);
            cloneTemp = cloneTemp.next;
            originalTemp = originalTemp.next;
        }

        return cloneHead.next;
    }


    //------------ Efficient solution-----------
    // TC - o(N), SC - o(1)
    // Efficient solution
    public static Node copyList(Node head) {
        Node clone = new Node(-1), cloneHead = clone;

        // clone linked list without random pointer
        Node originalNode = head;
        Node cloneNode = cloneHead;

        while(originalNode != null) {
            cloneNode.next = new Node(originalNode.value);
            cloneNode = cloneNode.next;
            originalNode = originalNode.next;
        }

        // map the original node with clone node
        originalNode = head;
        cloneNode = cloneHead.next;

        while(originalNode != null && cloneNode != null) {
            // changing connection for original node
            Node nxt = originalNode.next;
            originalNode.next = cloneNode;
            originalNode = nxt;

            // changing connection for clone node
            nxt = cloneNode.next;
            cloneNode.next = originalNode;
            cloneNode = nxt;
        }

        // connect the random pointer
        Node temp = head;

        while(temp != null) {
            if(temp.next != null && temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // reset the original node and clone node connections
        cloneNode = cloneHead.next;
        originalNode = head;

        while(cloneNode != null && originalNode != null) {
            // change original node connection
            originalNode.next = cloneNode.next;
            originalNode = originalNode.next;

            // change clone node connection
            if(originalNode != null) {
                cloneNode.next = originalNode.next;
            }
            cloneNode = cloneNode.next;
        }

        return cloneHead.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);
        s.insertLast(4);
        s.insertLast(5);
        Node head = copyList(s.head);
        s.display(head);
    }
}
