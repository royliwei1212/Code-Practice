package com.codeashobby.leetcode;

/**
 * Created by hzhou on 4/22/15. codeashobby@gmail.com
 */
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != null && fast != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			if (fast.next != null) {
				fast = fast.next.next;
			} else {
				fast = null;
			}
		}
		return false;
	}

	class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
