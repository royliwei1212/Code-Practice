package tech.saltyegg.leetcode;

import java.util.List;

/**
 * Created by hzhou on 2015/8/7.
 */
public class Vector2D {

    private int[] arrCounters;
    private int counter = 0;

    public Vector2D(List<List<Integer>> vec2d) {
        int cnt = 0;
        if (vec2d == null) {
            arrCounters = new int[0];
        } else {

            for (List<Integer> l : vec2d) {
                cnt += (l == null) ? 0 : l.size();
            }
            arrCounters = new int[cnt];

            cnt = 0;
            for (List<Integer> l : vec2d) {
                for (int in : l) {
                    arrCounters[cnt++] = in;
                }
            }
        }
    }

    public int next() {
        int val = Integer.MIN_VALUE;
        if (counter < arrCounters.length) {
            val = arrCounters[counter];
        }
        counter++;
        return val;
    }

    public boolean hasNext() {
        return counter < arrCounters.length;
    }

}
