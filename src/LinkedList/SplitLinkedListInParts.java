package LinkedList;

public class SplitLinkedListInParts {
    public static Node[] splitListToParts(Node head, int k) {
        // find the length of linked list
        Node[] ans = new Node[k];
        Node temp = head;
        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        // split ll into parts
        int parts = length / k;
        int remaining = length % k;
        int size = 0, i = 0;
        temp = head;
        Node prev = null;
        Node current = head;

        while(temp != null) {
            int eachPart = parts;
            ans[i] = temp;
            while(eachPart > 0) {
                prev = current;
                current = current.next;
                eachPart--;
            }

            // check if there are remaining nodes
            if(remaining != 0 && current != null) {
                prev = current;
                current = current.next;
                remaining--;
            }

            // if prev not null break connection
            if(prev != null) {
                temp = current;
                prev.next = null;
            }

            size++;
            i++;
        }

        // if size lesser than k
        while(size != k) {
            ans[i] = null;
            size++;
        }

        return ans;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(3);


        Node[] node = splitListToParts(s.head, 5);

    }
}
