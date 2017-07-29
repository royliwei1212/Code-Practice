package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }

        int result = 0;

        for (int[] p : points) {
            Map<Integer, Integer> dict = new HashMap<>();
            for (int[] q : points) {
                if (p == q) {
                    continue;
                }
                int dist = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                dict.put(dist, dict.getOrDefault(dist, 0) + 1);
            }
            result += dict.values().stream()
                    .filter(x -> x > 1)
                    .map(x -> x * (x - 1))
                    .mapToInt(Integer::intValue)
                    .sum();
        }

        return result;
    }

}
