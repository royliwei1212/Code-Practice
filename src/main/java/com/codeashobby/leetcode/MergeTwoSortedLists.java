/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.ListNode;

/**
 * Description
 *
 * @author hzhou
 */
public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode pre = new ListNode(0);
		ListNode cursor = pre;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				cursor.next = l2;
				l2 = l2.next;
			} else {
				cursor.next = l1;
				l1 = l1.next;
			}

			cursor = cursor.next;
		}

		if (l1 == null) {
			cursor.next = l2;
		} else {
			cursor.next = l1;
		}

		return pre.next;
	}
}