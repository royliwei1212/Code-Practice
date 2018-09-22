package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

import tech.saltyegg.leetcode.parent.Point;

/**
 * Created by hzhou on 2015/6/1. Email: codeashobby@gmail.com
 */
public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length < 3) return points.length;

        int result = 2;
        for (int i = 0; i < points.length - 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int same = 0;
            Point p = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point ps = points[j];
                if (p.x == ps.x && p.y == ps.y) {
                    same++;
                } else if (p.x == ps.x) {
                    map.put("Double.POSITIVE_INFINITY", map.getOrDefault("Double.POSITIVE_INFINITY", 1) + 1);
                } else if (p.y == ps.y) {
                    map.put("0.0", map.getOrDefault("0.0", 1) + 1);
                } else {
                    int y = p.y - ps.y;
                    int x = p.x - ps.x;
                    int gcd = gcd(y, x);
                    String key = y / gcd + "-" + x / gcd;
                    map.put(key, map.getOrDefault(key, 1) + 1);
                }
            }
            int localMax = 1;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                localMax = Math.max(localMax, entry.getValue());
            }
            result = Math.max(result, same + localMax);
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
