/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description
 *
 * @author hzhou
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) result.add(0);

        for (int i = 1; i <= rowIndex; i++) {
            result.set(i, 1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}