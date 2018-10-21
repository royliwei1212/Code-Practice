package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int result = 0;
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            while (map.size() > 2) {
                int p = tree[pre];
                int x = map.get(p);
                if (x == 1) {
                    map.remove(p);
                } else {
                    map.put(p, map.get(p) - 1);
                }
                pre++;
            }
            result = Math.max(result, i - pre + 1);
        }
        return result;
    }
}
