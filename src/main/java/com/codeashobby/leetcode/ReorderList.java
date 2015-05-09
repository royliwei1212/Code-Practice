/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.codeashobby.leetcode.parent.ListNode;

/**
 * Description Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn, reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * <p/>
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * @author hzhou
 */
public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}

		List<ListNode> list = new ArrayList<ListNode>();
		list.add(head);
		ListNode cursor = head.next;
		int count = 1;
		while (cursor != null) {
			list.add(cursor);
			cursor = cursor.next;
			count++;
		}

		for (int i = 0; i < count / 2; i++) {
			list.get(i).next = list.get(count - i - 1);
			list.get(count - i - 1).next = list.get(i + 1);
		}
		list.get(count / 2).next = null;
	}
}