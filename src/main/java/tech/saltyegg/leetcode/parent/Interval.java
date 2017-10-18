package tech.saltyegg.leetcode.parent;

/**
 * Created by hzhou on 2015/5/21.
 * Email: codeashobby@gmail.com
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Interval interval = (Interval) o;

        if (start != interval.start) {
            return false;
        }
        return end == interval.end;

    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}
