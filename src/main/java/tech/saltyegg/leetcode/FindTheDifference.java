package tech.saltyegg.leetcode;

import java.util.Arrays;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for (int i = 0; i < sa.length; i++) {
            if (ta[i] != sa[i]) {
                return ta[i];
            }
        }

        return ta[ta.length-1];
    }

}
