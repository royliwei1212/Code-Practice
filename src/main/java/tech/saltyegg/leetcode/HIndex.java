package tech.saltyegg.leetcode;

import java.util.Arrays;

/**
 * @author hzhou
 * @since 9/4/17
 */
public class HIndex {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);

        int result = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int index = citations.length - i;
            int citation = citations[i];
            if (citation < index) {
                return index - 1;

            } else {
                result = index;
            }
        }
        return result;
    }

}
