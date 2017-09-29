package tech.saltyegg.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/28/17
 */
public class LRUCache {
    private Map<Integer, LinkedNode> map;
    private int capacity;
    private LinkedNode head;
    private LinkedNode end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LinkedNode node = map.get(key);
            removeNode(node);
            addNodeToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        LinkedNode node = new LinkedNode(key, value);
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            addNodeToHead(node);
        } else {
            if (map.size() >= capacity) {
                removeNode(end);
                map.remove(end.key);
            }
            addNodeToHead(node);
        }
        map.put(key, node);
    }


    private void removeNode(LinkedNode node) {
        LinkedNode prev = node.prev;
        LinkedNode next = node.next;
        if (prev == null && next == null) {
            head = end = null;
        } else if (prev == null) {
            head = next;
            head.prev = null;
        } else if (next == null) {
            end = prev;
            end.next = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
    }

    private void addNodeToHead(LinkedNode node) {
        if (head == null) {
            head = end = node;
            return;
        }
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }

    private static class LinkedNode {
        int value;
        int key;
        LinkedNode prev = null;
        LinkedNode next = null;

        LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));

        cache.put(5, 5);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}
