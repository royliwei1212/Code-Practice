package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Created by hzhou on 5/4/15. codeashobby@gmail.com
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHeader = head;
        ListNode cursor = head.next;
        preHeader.next = null;

        ListNode tmp;
        while (cursor != null) {
            tmp = cursor.next;
            cursor.next = preHeader;
            preHeader = cursor;
            cursor = tmp;
        }

        return preHeader;
    }

}
