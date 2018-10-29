package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Created by hzhou on 2015/8/9.
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        assert node.next != null;

        while (node != null && node.next != null) {
            ListNode next = node.next;
            node.val = next.val;

            if (next.next == null) {
                node.next = null;
            }
            node = node.next;
        }
    }
}
