package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class LongestUncommonSubsequenceII {

    public int findLUSlength(String[] strs) {
        int result = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (i == j) continue;
                if (checkSubs(strs[i], strs[j])) break;
            }

            if (j == strs.length) result = Math.max(result, strs[i].length());
        }

        return result;
    }

    private boolean checkSubs(String subs, String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == subs.charAt(i)) ++i;
            if (i == subs.length()) break;
        }
        return i == subs.length();
    }

}
