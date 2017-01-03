/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.ListNode;

/**
 * Description:
 *
 * @author hzhou
 */
public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode cursor, pre;
		pre = head;
		cursor = head.next;
		while (cursor != null) {
			while (cursor != null && cursor.val == pre.val) {
				cursor = cursor.next;
			}

			if (cursor == null) {
				pre.next = null;
			} else {
				pre.next = cursor;
				pre = pre.next;
				cursor = cursor.next;
			}
		}

		return head;
	}
}