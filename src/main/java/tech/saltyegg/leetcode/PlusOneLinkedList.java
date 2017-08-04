package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

public class PlusOneLinkedList {

    public ListNode plusOne(ListNode head) {
        int x = helper(head);
        if (x == 1) {
            ListNode node = new ListNode(x);
            node.next = head;
            head = node;
        }
        return head;
    }

    private int helper(ListNode node) {
        if (node == null) return 0;
        if (node.next == null) {
            node.val += 1;
            int result = node.val / 10;
            node.val %= 10;
            return result;
        }

        int x = node.val + helper(node.next);
        node.val = x % 10;
        return x / 10;
    }
}
