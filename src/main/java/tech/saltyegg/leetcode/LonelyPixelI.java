package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzhou
 * @since 8/31/17
 */
public class LonelyPixelI {

    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0] == null || picture[0].length == 0) {
            return 0;
        }

        Map<Integer, Integer> colMap = new HashMap<>();
        Map<Integer, Integer> rowMap = new HashMap<>();
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
                if (picture[i][j] == 'B' && colMap.getOrDefault(j, 0) == 1 && rowMap.getOrDefault(i, 0) == 1) {
                    result++;
                }
            }
        }

        return result;
    }

}
