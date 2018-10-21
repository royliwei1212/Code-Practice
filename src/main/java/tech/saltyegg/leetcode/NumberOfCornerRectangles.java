package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class NumberOfCornerRectangles {

    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length < 2 || grid[0] == null || grid[0].length < 2) return 0;
        int result = 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                Set<Integer> set = map.getOrDefault(i, new HashSet<>());
                set.add(j);
                map.put(i, set);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (map.containsKey(i) && map.get(i).size() == 1) map.remove(i);
        }

        if (map.size() < 2) return 0;

        for (int i = 0; i < grid.length - 1; i++) {
            if (!map.containsKey(i)) continue;
            List<Integer> list = new ArrayList<>(map.get(i));
            for (int m = 0; m < list.size() - 1; m++) {
                for (int n = m + 1; n < list.size(); n++) {
                    for (int k = i + 1; k < grid.length; k++) {
                        if (!map.containsKey(k) || !map.get(k).contains(list.get(m)) || !map.get(k).contains(list.get(n)))
                            continue;
                        result++;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{{0, 1, 0}, {1, 0, 1}, {1, 0, 1}, {0, 1, 0}};
        System.out.println(countCornerRectangles(grid));
    }
}
