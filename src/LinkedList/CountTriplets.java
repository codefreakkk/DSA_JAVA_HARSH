package LinkedList;

import java.util.HashMap;

public class CountTriplets {

    public static int countTriplets(Node head, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Node temp = head;

        int count = 0;
        while(temp != null) {
            int value = x - temp.value;
            Node current = temp.next;
            while(current != null) {
                if(map.containsKey(value - current.value)) {
                    count++;
                }
                map.put(current.value, current.value);
                current = current.next;
            }
            map.clear();
            temp = temp.next;
        }

        return count;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation s = new SinglyLinkedListCreation();
        s.insertLast(1);
        s.insertLast(2);
        s.insertLast(4);
        s.insertLast(5);
        s.insertLast(6);
        s.insertLast(8);
        s.insertLast(9);
        System.out.println(countTriplets(s.head, 15));
    }
}
