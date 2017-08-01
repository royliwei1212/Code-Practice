package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        List<Point> list = new ArrayList<>();
        for (String s : timePoints) {
            list.add(new Point(s));
        }
        list.sort(Point::compareTo);
        Point p0 = list.get(0);
        list.add(new Point(p0.hour + 24, p0.minute));
        int result = Integer.MAX_VALUE;
        int half = 12 * 60;
        Point pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Point p = list.get(i);
            int diff = p.getMinute() - pre.getMinute();
            result = Math.min(result, diff > half ? 2 * half - diff : diff);
            pre = p;
        }

        return result;
    }

    private static class Point implements Comparable<Point> {
        int hour;
        int minute;

        Point(String s) {
            String[] arr = s.split(":");
            hour = Integer.valueOf(arr[0]);
            minute = Integer.valueOf(arr[1]);
        }

        Point(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public int compareTo(Point o) {
            return this.getMinute() - o.getMinute();
        }

        int getMinute() {
            return hour * 60 + minute;
        }
    }
}
