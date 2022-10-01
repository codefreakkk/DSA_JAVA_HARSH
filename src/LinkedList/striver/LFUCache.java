package LinkedList.striver;

import java.util.HashMap;

public class LFUCache {
    HashMap<Integer, LFULinkedList> frequencyMap;
    HashMap<Integer, LFUNode> cache;

    int capacity;
    int minFrequency;
    int currSize;

    public LFUCache(int capacity) {
        frequencyMap = new HashMap<>();
        cache = new HashMap<>();

        this.capacity = capacity;
        this.minFrequency = 0;
        this.currSize = 0;
    }

    public int get(int key) {
        LFUNode node = cache.get(key);
        if(node == null) return -1;
        else {
            updateNode(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }

        if(cache.containsKey(key)) {
            LFUNode node = cache.get(key);
            node.value = value;
            updateNode(node);
        }
        else {
            currSize++;

            // if current size overflows capacity
            if(currSize > capacity) {
                LFULinkedList list = frequencyMap.get(minFrequency);
                cache.remove(list.tail.prev.key);
                list.removeNode(list.tail.prev);
                currSize--;
            }

            minFrequency = 1;
            LFUNode newNode = new LFUNode(key, value);

            LFULinkedList newList = frequencyMap.getOrDefault(minFrequency, new LFULinkedList());
            newList.addNode(newNode);
            frequencyMap.put(minFrequency, newList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(LFUNode node) {
        int frequency = node.frequency;
        LFULinkedList lfu = frequencyMap.get(frequency);
        lfu.removeNode(node);

        // if list becomes empty then increase minFrequency
        if(frequency == minFrequency && lfu.listSize == 0) {
            minFrequency++;
        }

        // update the frequency of node and frequency map
        node.frequency++;
        LFULinkedList newList = frequencyMap.getOrDefault(node.frequency, new LFULinkedList());
        newList.addNode(node);
        frequencyMap.put(node.frequency, newList);
    }
}

class LFUNode {
    int key, value;
    int frequency;
    LFUNode prev, next;

    public LFUNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}

class LFULinkedList {
    public int listSize;
    public LFUNode head;
    public LFUNode tail;

    public LFULinkedList() {
        this.head = new LFUNode(0, 0);
        this.tail = new LFUNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(LFUNode node) {
        LFUNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        this.listSize++;
    }

    public void removeNode(LFUNode node) {
        LFUNode nextNode = node.next;
        LFUNode prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;
    }
}