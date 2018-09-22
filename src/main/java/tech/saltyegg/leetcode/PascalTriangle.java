/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Description
 *
 * @author hzhou
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return result;
        }
        List<Integer> tmp1 = new ArrayList<Integer>();
        tmp1.add(1);
        result.add(tmp1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<Integer>();
            List<Integer> pre = result.get(i - 1);
            for (int k = 0; k <= i; k++) {

                tmp.add(k == 0 ? pre.get(k) : k == i ? pre.get(k - 1) : pre.get(k - 1) + pre.get(k));
            }
            result.add(tmp);
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Integer>> result = generate(5);
    }
}