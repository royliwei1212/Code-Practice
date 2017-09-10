package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/10/17
 */
public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        for (int[] a : updates) {
            for (int i = a[0]; i <= a[1]; i++) {
                result[i] += a[2];
            }
        }
        return result;
    }

}
