package LinkedList.codehelp;

public class SortLinkedListOf012 {
    // not much efficient
    public static Node segregate(Node head) {
        if(head == null) return head;

        int zeroCount = 0, oneCount = 0, twoCount = 0;

        Node temp = head;
        while(temp != null) {
            if(temp.value == 0) zeroCount++;
            else if(temp.value == 1) oneCount++;
            else if(temp.value == 2) twoCount++;
            temp = temp.next;
        }

        temp = head;
        while(temp != null) {
            if(zeroCount != 0) {
                temp.value = 0;
                zeroCount--;
            }
            else if(oneCount != 0) {
                temp.value = 1;
                oneCount--;
            }
            else if(twoCount != 0) {
                temp.value = 2;
                twoCount--;
            }
            temp = temp.next;
        }

        return head;
    }

    // efficient
    public static Node sortList(Node head) {
        if(head == null) return head;

        Node zeroDummy = new Node(-1), zeroTemp = zeroDummy;
        Node oneDummy = new Node(-1), oneTemp = oneDummy;
        Node twoDummy = new Node(-1), twoTemp = twoDummy;

        Node temp = head;
        while(temp != null) {
            if(temp.value == 0) {
                zeroTemp.next = temp;
                zeroTemp = zeroTemp.next;
            }
            else if(temp.value == 1) {
                oneTemp.next = temp;
                oneTemp = oneTemp.next;
            }
            else if(temp.value == 2) {
                twoTemp.next = temp;
                twoTemp = twoTemp.next;
            }

            temp = temp.next;
        }

        // make final connections
        if(oneDummy.next != null) zeroTemp.next = oneDummy.next;
        else zeroTemp.next = twoDummy.next;

        oneTemp.next = twoDummy.next;
        twoTemp.next = null;

        return zeroDummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(2);
//        s.insertLast(0);
//        s.insertLast(0);
        s.insertLast(2);
        s.insertLast(1);

        s.display();
        Node head = sortList(s.head);
        s.display(head);
    }
}
