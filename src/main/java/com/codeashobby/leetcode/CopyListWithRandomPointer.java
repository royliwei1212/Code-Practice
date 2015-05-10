/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.codeashobby.leetcode.parent.RandomListNode;

/**
 * Description: A linked list is given such that each node contains an additional random pointer which could point to
 * any node in the list or null.
 * <p/>
 * Return a deep copy of the list.
 *
 * @author hzhou
 */
public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		RandomListNode cursor = head;
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		while (cursor != null) {
			RandomListNode tmp = new RandomListNode(cursor.label);
			map.put(cursor, tmp);
			cursor = cursor.next;
		}

		cursor = head;
		while (cursor != null) {
			RandomListNode tmp = map.get(cursor);
			tmp.next = cursor.next != null ? map.get(cursor.next) : null;
			tmp.random = cursor.random != null ? map.get(cursor.random) : null;
			cursor = cursor.next;
		}

		return map.get(head);
	}
}