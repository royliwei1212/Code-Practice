package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hzhou
 * @since 9/6/17
 */
public class PerfectRectangle {

    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int area = 0;

        for (int[] p : rectangles) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
            maxX = Math.max(maxX, p[2]);
            maxY = Math.max(maxY, p[3]);

            String lb = p[0] + "_" + p[1];
            String lt = p[0] + "_" + p[3];
            String rb = p[2] + "_" + p[1];
            String rt = p[2] + "_" + p[3];
            if (!set.contains(lb))  set.add(lb); else  set.remove(lb);
            if (!set.contains(lt))  set.add(lt); else  set.remove(lt);
            if (!set.contains(rb))  set.add(rb); else  set.remove(rb);
            if (!set.contains(rt))  set.add(rt); else  set.remove(rt);

            area += (p[2] - p[0]) * (p[3] - p[1]);
        }
        String s1 = minX + "_" + minY;
        String s2 = minX + "_" + maxY;
        String s3 = maxX + "_" + maxY;
        String s4 = maxX + "_" + minY;
        if (!set.contains(s1) ||
                !set.contains(s2) ||
                !set.contains(s3) ||
                !set.contains(s4)) {
            return false;
        }
        return set.size() == 4 && area == (maxX - minX) * (maxY - minY);

    }

}
