package tech.saltyegg.leetcode;

/**
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * @author hzhou
 * @since 4/15/17
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(new StringBuffer(str).reverse()).append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

}
