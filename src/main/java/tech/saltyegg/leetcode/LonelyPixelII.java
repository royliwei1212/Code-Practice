package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzhou
 * @since 8/31/17
 */
@SuppressWarnings("Duplicates")
public class LonelyPixelII {

    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length < N || picture[0] == null || picture[0].length < N) {
            return 0;
        }

        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> sameRowMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    colMap.put(j, colMap.getOrDefault(j, 0) + 1);
                    rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
                }
            }
        }

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    // result++;
                    List<Integer> rows = sameRowMap.getOrDefault(j, new ArrayList<>());
                    rows.add(i);
                    sameRowMap.put(j, rows);
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : sameRowMap.entrySet()) {
            List<Integer> val = entry.getValue();
            int R = val.get(0);
            boolean allSame = true;
            for (int i = 1; i < val.size(); i++) {
                if (!isSameRow(picture[R], picture[val.get(i)])) {
                    allSame = false;
                    break;
                }
            }

            if (allSame &&
                    colMap.getOrDefault(entry.getKey(), 0) == N &&
                    rowMap.getOrDefault(R, 0) == N) {
                result += val.size();
            }

        }

        return result;
    }

    private boolean isSameRow(char[] a, char[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

}
