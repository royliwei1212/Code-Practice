package tech.saltyegg.leetcode;

import java.util.List;

public class ConvexPolygon {

    // https://leetcode.com/problems/convex-polygon/discuss/95573/i-believe-this-time-its-far-beyond-my-ability-to-get-a-good-grade-of-the-contest
    public boolean isConvex(List<List<Integer>> points) {
        if (points == null || points.size() < 3) return false;
        int size = points.size();
        long pre = 0;
        for (int i = 0; i < size; i++) {
            List<Integer> p0 = points.get(i);
            List<Integer> p1 = points.get((i + 1) % size);
            List<Integer> p2 = points.get((i + 2) % size);
            long crt = (long) (p1.get(0) - p0.get(0)) * (p2.get(1) - p0.get(1)) - (long) (p2.get(0) - p0.get(0)) * (p1.get(1) - p0.get(1));
            if (crt != 0) {
                if (crt * pre < 0) return false;
                pre = crt;
            }
        }
        return true;
    }
}
