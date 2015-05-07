package com.codeashobby.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.codeashobby.leetcode.parent.ListNode;

/**
 * Created by hzhou on 5/6/15. codeashobby@gmail.com
 */
public class MergeKSortedListsII {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length < 1) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return 1;
				} else if (o1.val == o2.val) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		for (ListNode n : lists) {
			if (n != null) {
				queue.add(n);
			}
		}
		ListNode preHead = new ListNode(0);
		ListNode cursor = preHead;

		while (!queue.isEmpty()) {
			ListNode tmp = queue.poll();
			cursor.next = tmp;
			if (tmp.next != null) {
				queue.offer(tmp.next);
			}
			cursor = cursor.next;
		}

		return preHead.next;
	}

}
