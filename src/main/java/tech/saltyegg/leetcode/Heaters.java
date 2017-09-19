package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/19/17
 */
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0) return -1;
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int result = 0;
        int start = 0;
        for (int h : houses) {
            while (start < heaters.length - 1 && Math.abs(heaters[start + 1] - h) <= Math.abs(heaters[start] - h)) {
                start++;
            }
            result = Math.max(result, Math.abs(heaters[start] - h));
        }
        return result;
    }

}
