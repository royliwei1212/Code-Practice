/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */

// TODO: not finished
public class ContainsDuplicateIII {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length < 2 || k < 1) {
			return false;
		}

		List<Item> list = new ArrayList<Item>();
		for (int i = 0; i < nums.length; i++) {
			list.add(new Item(i, nums[i]));
		}
		Collections.sort(list, new Comparator<Item>() {
			public int compare(Item o1, Item o2) {
				return o1.val - o2.val;
			}
		});

		for (int i = 0; i < list.size(); i++) {
			Item item = list.get(i);
			for (int j = i + 1; j <= i + k && j < list.size(); j++) {
				Item item2 = list.get(j);
				if (item2.index == item.index) {
					continue;
				}
				if (Math.abs(item.val - item2.val) > t) {
					break;
				}

				if (Math.abs(item2.index - item.index) <= k && Math.abs(item.val - item2.val) <= t) {
					return true;
				}
			}
		}

		return false;
	}

	static class Item {

		int index;
		int val;

		Item(int index, int val) {
			this.index = index;
			this.val = val;
		}
	}

	@Test
	public void test() {
		int[] nums = new int[]{1, 3, 6, 2};
		boolean b = containsNearbyAlmostDuplicate(nums, 1, 2);
	}
}