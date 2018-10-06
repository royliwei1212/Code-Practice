package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Description:
 *
 * @author hzhou
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cursor, pre;
        pre = head;
        cursor = head.next;
        while (cursor != null) {
            while (cursor != null && cursor.val == pre.val) {
                cursor = cursor.next;
            }

            if (cursor == null) {
                pre.next = null;
            } else {
                pre.next = cursor;
                pre = pre.next;
                cursor = cursor.next;
            }
        }

        return head;
    }
}