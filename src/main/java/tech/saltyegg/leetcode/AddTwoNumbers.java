package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Created by hzhou on 4/23/15. codeashobby@gmail.com
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        boolean inc = false;
        int sum = 0;
        ListNode result = l1;
        ListNode tmp;

        if (getLength(l1) >= getLength(l2)) {
            result = l1;
            tmp = l2;
        } else {
            result = l2;
            tmp = l1;
        }
        ListNode cursor = result;

        while (tmp != null && tmp.next != null) {
            sum = result.val + tmp.val + (inc ? 1 : 0);
            result.val = sum % 10;
            inc = (sum > 9);
            result = result.next;
            tmp = tmp.next;
        }

        sum = result.val + tmp.val + (inc ? 1 : 0);
        result.val = sum % 10;
        inc = (sum > 9);
        while (result.next != null) {
            result = result.next;
            sum = result.val + (inc ? 1 : 0);
            result.val = sum % 10;
            inc = (sum > 9);
        }
        if (inc) {
            result.next = new ListNode(1);
        }

        return cursor;
    }

    private int getLength(ListNode list) {
        ListNode cursor = list;
        int len = 0;
        while (cursor != null) {
            len++;
            cursor = cursor.next;
        }
        return len;
    }

}
