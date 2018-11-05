package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 10/11/17
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) return false;
        if (maxChoosableInteger >= desiredTotal || sum == desiredTotal && maxChoosableInteger % 2 == 1) return true;

        Map<String, Boolean> map = new HashMap<>();
        return helper(maxChoosableInteger, desiredTotal, new int[maxChoosableInteger + 1], map);
    }

    private boolean helper(int m, int d, int[] visited, Map<String, Boolean> map) {
        if (d <= 0) return false;
        String vs = Arrays.toString(visited);
        if (map.containsKey(vs)) return map.get(vs);
        for (int i = 1; i <= m; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            if (!helper(m, d - i, visited, map)) {
                map.put(vs, true);
                visited[i] = 0;
                return true;
            }
            visited[i] = 0;
        }
        map.put(vs, false);
        return false;
    }
}
