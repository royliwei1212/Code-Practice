package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Union find
public class NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0) return result;

        Map<Integer, Integer> map = new HashMap<>();
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;

        for (int[] p : positions) {
            int x = p[0];
            int y = p[1];
            map.put(n * x + y, n * x + y);
            count++;
            for (int[] d : direction) {
                int xx = x + d[0];
                int yy = y + d[1];
                int pos = xx * n + yy;
                if (xx < 0 || yy < 0 || xx >= m || yy >= n || !map.containsKey(pos)) continue;
                int rx = findRoot(n * x + y, map);
                int ry = findRoot(pos, map);
                if (rx != ry) {
                    count--;
                    map.put(rx, ry);
                }
            }
            result.add(count);
        }
        return result;
    }

    private int findRoot(int p, Map<Integer, Integer> map) {
        int root = map.get(p);
        while (root != map.get(root)) {
            root = map.get(root);
        }

        while (p != map.get(p)) {
            int t = map.get(p);
            map.put(p, root);
            p = t;
        }
        return root;
    }
}
