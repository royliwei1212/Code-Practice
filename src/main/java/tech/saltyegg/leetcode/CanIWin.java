package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 10/11/17
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        Map<Integer, Boolean> map = new HashMap<>();
        return helper(maxChoosableInteger, desiredTotal, 0, map);
    }

    private boolean helper(int m, int d, int used, Map<Integer, Boolean> map) {
        if (map.containsKey(used)) return map.get(used);
        for (int i = 0; i < m; i++) {
            int crt = 1 << i;
            if ((crt & used) == 0) {
                if (d <= i + 1 || !helper(m, d - (i + 1), used | crt, map)) {
                    map.put(used, true);
                    return true;
                }
            }
        }
        map.put(used, false);
        return false;
    }
}
