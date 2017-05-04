/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Description
 *
 * @author hzhou
 */
public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode fast = head.next.next;
		ListNode slow = head.next;

		while (fast != null && fast != slow) {
			slow = slow.next;
			fast = fast.next != null ? fast.next.next : null;
		}

		if (fast == null) {
			return null;
		}

		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
	}
}