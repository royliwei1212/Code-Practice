package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 4/26/17
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) {
            return s;
        }

        String[] arr = s.split("(?<=\\G.{" + k + "})");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                sb.append(arr[i]);
            } else {
                sb.append(new StringBuilder(arr[i]).reverse().toString());
            }
        }
        return sb.toString();
    }

}
