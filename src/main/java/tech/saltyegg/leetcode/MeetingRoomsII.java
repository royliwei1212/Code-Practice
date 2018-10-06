package tech.saltyegg.leetcode;

import java.util.Map;
import java.util.TreeMap;

import tech.saltyegg.leetcode.parent.Interval;

public class MeetingRoomsII {

    // find the overlap count

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }

        int result = 0, room = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            room += e.getValue();
            result = Math.max(result, room);
        }
        return result;
    }

}