package LinkedList.faraz;

import java.util.*;

public class DesignHashSetUsingLinkedList {
    List<LinkedList<Integer>> list;
    int size;

    public DesignHashSetUsingLinkedList() {
        size = 100;
        list = new ArrayList<>(size);
        init();
    }

    public int hash(int key) {
        return key % size;
    }

    public void add(int key) {
        int i = hash(key);

        // get the linked list of corresponding index and then insert key
        LinkedList<Integer> temp = list.get(i);
        if(temp.contains(key)) return;
        temp.add(key);
    }

    public void remove(int key) {
        int i = hash(key);
        LinkedList<Integer> temp = list.get(i);
        if(temp.contains(key)) {
            int index = temp.indexOf(key);
            if(index >= 0) temp.remove(index);
        }
    }

    public boolean contains(int key) {
        int i = hash(key);
        if(list.get(i).contains(key)) return true;
        return false;
    }

    // add elements in list
    public void init() {
        for (int i = 0; i < size; i++) {
            list.add(new LinkedList<>());
        }
    }

    public static void main(String[] args) {

    }
}
