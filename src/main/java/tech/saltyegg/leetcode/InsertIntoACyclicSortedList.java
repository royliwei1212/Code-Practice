package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.Node;

public class InsertIntoACyclicSortedList {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node cursor = head.next;
        int min = head.val;
        int max = head.val;
        Node end = head;

        while (cursor != head) {
            min = Math.min(min, cursor.val);
            max = Math.max(max, cursor.val);
            if (cursor.val > cursor.next.val) end = cursor;
            cursor = cursor.next;
        }

        if (insertVal <= min || insertVal >= max) {
            Node t = end.next;
            end.next = new Node(insertVal);
            end.next.next = t;
        } else {
            cursor = head;
            while (!(cursor.val <= insertVal && cursor.next.val >= insertVal)) {
                cursor = cursor.next;
            }
            Node t = cursor.next;
            cursor.next = new Node(insertVal);
            cursor.next.next = t;
        }

        return head;
    }
}
