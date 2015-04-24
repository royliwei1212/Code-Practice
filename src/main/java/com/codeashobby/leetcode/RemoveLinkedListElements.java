package com.codeashobby.leetcode;

/**
 * Created by hzhou on 4/23/15. codeashobby@gmail.com
 */
public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode preHeader = new ListNode(val - 1);
		preHeader.next = head;
		ListNode cursor = preHeader;

		while (cursor != null && cursor.next != null) {
			if (cursor.next.val == val) {
				cursor.next = cursor.next.next;
			} else {
				cursor = cursor.next;
			}
		}

		return preHeader.next;
	}

	public class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
