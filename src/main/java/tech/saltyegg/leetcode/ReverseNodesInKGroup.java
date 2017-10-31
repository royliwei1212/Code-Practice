package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Created by hzhou on 2015/5/21.
 * Email: codeashobby@gmail.com
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        int length = 0;
        ListNode c = head;
        while (c != null) {
            length++;
            c = c.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (length >= k) {
            c = pre.next;
            for (int i = 1; i < k; i++) {
                ListNode t = c.next;
                c.next = t.next;
                t.next = pre.next;
                pre.next = t;
            }
            pre = c;
            length -= k;
        }
        return dummy.next;
    }
}
