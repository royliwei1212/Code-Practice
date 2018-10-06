package tech.saltyegg.leetcode;

import org.junit.Test;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Description: Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * @author hzhou
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow;
        slow = slow.next;
        tmp.next = null;


        ListNode next = slow.next;
        slow.next = null;
        while (next != null) {
            tmp = next.next;
            next.next = slow;
            slow = next;
            next = tmp;
        }

        ListNode cursor = head;
        fast = head.next;
        boolean f = false;
        while (fast != null && slow != null) {
            if (f) {
                cursor.next = fast;
                fast = fast.next;
            } else {
                cursor.next = slow;
                slow = slow.next;
            }
            f = !f;
            cursor = cursor.next;
        }
        if (fast != null) cursor.next = fast;
        if (slow != null) cursor.next = slow;
    }
}