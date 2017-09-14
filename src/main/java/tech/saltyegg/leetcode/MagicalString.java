package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class MagicalString {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int start = 2;
        while (sb.length() < n) {
            char last = sb.charAt(sb.length() - 1);
            char current = sb.charAt(start++);
            if (current == '1') {
                sb.append(3 - (last - '0'));
            } else {
                sb.append(3 - (last - '0')).append(3 - (last - '0'));
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') result++;
        }
        return result;
    }
}
