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
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ;
        ListNode half = slow.next;
        if (half.next == null && half.val != head.val) return false;
        // reverse half now
        slow.next = null;
        ListNode p = half;
        ListNode c = p.next;
        p.next = null;

        while (c != null) {
            ListNode t = c.next;
            c.next = p;
            p = c;
            c = t;
        }
        slow = head;
        while (slow != null && p != null) {
            if (slow.val != p.val) return false;
            slow = slow.next;
            p = p.next;
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
