/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

import com.codeashobby.leetcode.parent.Interval;
import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class MeetingRoomsII {

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (o1, o2) -> {
			int r = o1.start - o2.start;
			return r == 0 ? o1.end - o2.end : r;
		});

		TreeSet<Interval> treeSet = new TreeSet<>((o1, o2) -> o1.end - o2.end);

		treeSet.add(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			Interval val = treeSet.first();
			Interval in = intervals[i];
			if (in.start >= val.end) {
				treeSet.remove(val);
			}
			treeSet.add(in);
		}

		return treeSet.size();
	}

	@Test
	public void test() {
		Interval[] intervals = new Interval[]{new Interval(5, 8), new Interval(6, 8)};
		//System.out.println(minMeetingRooms(intervals));

		TreeSet<Interval> treeSet = new TreeSet<>();
		for(Interval i : intervals) {
			treeSet.add(i);
		}
	}
}