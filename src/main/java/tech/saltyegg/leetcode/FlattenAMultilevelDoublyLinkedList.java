package tech.saltyegg.leetcode;


public class FlattenAMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (head == null) return head;
        Node cursor = head;
        while (cursor != null) {

            if (cursor.child != null) {
                Node child = cursor.child;
                Node tail = tail(child);

                tail.next = cursor.next;
                child.prev = cursor;
                cursor.child = null;
                if (cursor.next != null) cursor.next.prev = tail;
                cursor.next = child;
            }
            cursor = cursor.next;
        }
        return head;
    }

    private Node tail(Node node) {
        if (node == null) return node;
        Node cursor = node;
        while (cursor.next != null) cursor = cursor.next;
        return cursor;
    }

    class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}
