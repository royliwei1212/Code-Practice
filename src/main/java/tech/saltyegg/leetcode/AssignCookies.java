package tech.saltyegg.leetcode;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            int a = g[i];
            int b = s[j];
            if (b >= a) {
                result++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return result;
    }

}
