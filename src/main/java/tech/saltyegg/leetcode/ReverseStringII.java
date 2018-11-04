package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 4/26/17
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty() || k <= 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            String sub = s.substring(i, i + k >= s.length() ? s.length() : i + k);
            sb.append(new StringBuilder(sub).reverse());
            for (int j = i + k; j < Math.min(s.length(), i + 2 * k); j++) {
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }

}
