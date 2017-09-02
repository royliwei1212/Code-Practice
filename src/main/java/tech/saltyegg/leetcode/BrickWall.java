package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/2/17
 */
public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {

        int sum = wall.get(0).stream().mapToInt(Integer::intValue).sum();

        Map<Integer, Integer> dict = new HashMap<>();

        for (List<Integer> list : wall) {
            int s = 0;
            for (int x : list) {
                s += x;
                if (s < sum) {
                    dict.put(s, dict.getOrDefault(s, 0) + 1);
                }
            }
        }

        int result = wall.size();

        for (int x : dict.values()) {
            result = Math.min(result, wall.size() - x);
        }

        return result;
    }

}
