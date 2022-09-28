package LinkedList.faraz;

import java.util.*;

class Pair {
    protected int key;
    protected int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class DesignHashMapUsingLinkedList {

    List<LinkedList<Pair>> list;
    int size;

    public DesignHashMapUsingLinkedList() {
        size = 100;
        list = new ArrayList<>();
        init();
    }

    public int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        remove(key);

        // get the linked list of corresponding index
        LinkedList<Pair> temp = list.get(index);
        temp.add(new Pair(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        LinkedList<Pair> temp = list.get(index);
        int llSize = temp.size();

        // traverse the linked list and search for the key
        for(int i = 0; i < llSize; i++) {
            Pair p = temp.get(i);
            if(p.key == key) {
                return p.value;
            }
        }

        return -1;
    }

    public int getIndexOfLL(int key) {
        int index = hash(key);
        LinkedList<Pair> temp = list.get(index);

        for(int i = 0; i < temp.size(); i++) {
            Pair p = temp.get(i);
            if(p.key == key) return i;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Pair> temp = list.get(index);
        if(get(key) != -1) {
            int llIndex = getIndexOfLL(key);
            temp.remove(llIndex);
        }
    }

    public void init() {
        for(int i = 0; i < size; i++) {
            list.add(new LinkedList<>());
        }
    }

    public static void main(String[] args) {

    }
}
