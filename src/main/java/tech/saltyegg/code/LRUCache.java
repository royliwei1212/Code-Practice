package tech.saltyegg.code;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private LinkedNode head;
    private LinkedNode tail;
    private Map<Integer, LinkedNode> map;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        LinkedNode node = map.get(key);
        if (node == head) return node.val;

        if (node == tail) {
            node.prev.next = null;
            tail = node.prev;
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        } else {
            LinkedNode pre = node.prev;
            LinkedNode next = node.next;
            pre.next = next;
            next.prev = pre;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
            return;
        }
        LinkedNode node = new LinkedNode();
        node.key = key;
        node.val = value;
        if (map.size() >= capacity) {
            map.remove(tail.key);
            if (capacity == 1) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
        map.put(key, node);
        if (head == null && tail == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

    }


    private static class LinkedNode {
        int key;
        int val;
        LinkedNode prev;
        LinkedNode next;
    }

}
