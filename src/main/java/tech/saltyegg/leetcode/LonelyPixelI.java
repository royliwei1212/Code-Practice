package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hzhou
 * @since 8/31/17
 */
public class LonelyPixelI {

    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0] == null || picture[0].length == 0) {
            return 0;
        }

        Set<Integer> cs = new HashSet<>();
        Set<Integer> rs = new HashSet<>();
        int result = 0;

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (rs.contains(i)) {
                    break;
                }
                if (cs.contains(j)) {
                    continue;
                }
                char c = picture[i][j];
                if (c == 'B') {
                    rs.add(i);
                    cs.add(j);
                    boolean hasB = false;
                    for (int x = 0; x < picture[i].length; x++) {
                        if (x != j && picture[i][x] == 'B') {
                            hasB = true;
                            cs.add(x);
                        }
                    }
                    for (int x = 0; x < picture.length; x++) {
                        if (x != i && picture[x][j] == 'B') {
                            hasB = true;
                            rs.add(x);
                        }
                    }
                    if (!hasB) result++;
                }
            }
        }
        return result;
    }

}
