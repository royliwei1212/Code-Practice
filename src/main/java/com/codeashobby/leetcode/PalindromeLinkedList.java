package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.ListNode;
import org.junit.Test;

/**
 * Created by hzhou on 2015/8/10.
 * Email: i@hzhou.me
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode half = reverse(slow.next);
        fast = head;
        while (half != null && fast != null) {
            if (half.val != fast.val) {
                return false;
            }
            half = half.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cursor = head;
        ListNode next = cursor.next;
        ListNode tmp;
        cursor.next = null;
        while (next != null) {
            //cursor.next = null;
            tmp = next.next;
            next.next = cursor;
            cursor = next;
            if (tmp != null) {
                next = tmp;
            } else {
                break;
            }
        }
        return next;
    }

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        //a.next.next = new ListNode(3);
        //a.next.next.next = new ListNode(4);
        boolean result = isPalindrome(a);
    }
}
