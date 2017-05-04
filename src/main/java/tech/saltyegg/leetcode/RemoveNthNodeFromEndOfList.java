package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Created by hzhou on 5/6/15. codeashobby@gmail.com
 */
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		if(n == 0) return head;

		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode c1 = head;
		ListNode c2 = head;
		while (n > 0) {
			c2 = c2.next;
			n--;
		}

		if(c2 == null) {
			return head.next;
		}

		while(c2.next != null) {
			c1 = c1.next;
			c2 = c2.next;
		}

		c1.next = c1.next.next;

		return head;
	}

}
