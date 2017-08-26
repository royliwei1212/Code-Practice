package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 8/26/17
 */
public class AddBoldTagInString {

    public String addBoldTag(String s, String[] dict) {
        boolean[] bools = new boolean[s.length()];
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            for (String d : dict) {
                int l = d.length();
                if (i + l <= s.length() && s.substring(i, i + l).equals(d)) {
                    end = Math.max(end, i + l);
                }
            }

            bools[i] = end > i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bools.length; i++) {
            if (!bools[i]) {
                sb.append(s.charAt(i));
                continue;
            }

            int j = i;
            while (j < s.length() && bools[j]) {
                j++;
            }
            sb.append("<b>").append(s.substring(i, j)).append("</b>");
            i = j - 1;
        }
        return sb.toString();
    }
}
