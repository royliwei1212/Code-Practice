package tech.saltyegg.leetcode;

import org.junit.Test;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Created by hzhou on 2015/8/10.
 * Email: i@hzhou.me
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;

        ListNode pre = slow, crt = slow.next;
        pre.next = null;
        while (crt != null) {
            ListNode t = crt.next;
            crt.next = pre;
            pre = crt;
            crt = t;
        }

        fast = head;
        while (pre != null) {
            if (fast.val != pre.val) return false;
            pre = pre.next;
            fast = fast.next;
        }
        return true;
    }

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        //a.next.next = new ListNode(3);
        //a.next.next.next = new ListNode(4);
        System.out.println(isPalindrome(a));
    }
}
