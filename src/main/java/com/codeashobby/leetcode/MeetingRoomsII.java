/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.Arrays;

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

		int roomCount = 1;
		int mostRight = 0;
		int minCount = 1;

		Arrays.sort(intervals, (o1, o2) -> {
			int r = o1.start - o2.start;
			return r == 0 ? o1.end - o2.end : r;
		});

		for (int i = 0; i < intervals.length - 1; i++) {
			Interval starter = intervals[i];
			if (mostRight > starter.end) {
				continue;
			}

			mostRight = starter.end;

			for (int j = 1 + i; j < intervals.length; j++) {
				Interval in = intervals[j];
				if (in.start < mostRight) {
					roomCount++;
				} else {
					minCount = Math.max(minCount, roomCount);
					roomCount = 1;
				}
			}
		}
		return minCount;
	}

	@Test
	public void test() {
		Interval[] intervals = new Interval[]{new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
		System.out.println(minMeetingRooms(intervals));
	}
}