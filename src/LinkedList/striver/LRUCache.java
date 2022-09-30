package LinkedList.striver;

import java.util.HashMap;

class LRU {
    public int key, value;
    LRU next = null, prev = null;

    public LRU(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {

    HashMap<Integer, LRU> map = new HashMap<>();
    LRU head = new LRU(0, 0);
    LRU tail = new LRU(0, 0);
    int capacity;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        capacity = capacity;
    }

    public void remove(LRU node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(LRU node) {
        map.put(node.key, node);
        LRU next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else {
            // delete node and insert it at first
            LRU node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        // if cache already has key then remove it
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        if(capacity == map.size()) {
            remove(tail.prev);
        }
        insert(new LRU(key, value));
    }

    public static void main(String[] args) {

    }
}
