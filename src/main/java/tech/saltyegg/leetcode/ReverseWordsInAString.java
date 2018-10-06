package tech.saltyegg.leetcode;

/**
 * Description: Given an input string, reverse the string word by word.
 * <p/>
 * For example, Given s = "the sky is blue", return "blue is sky the".
 *
 * @author hzhou
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }

        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = splits.length - 1; i >= 0; i--) {
            String str = splits[i].trim();
            if (!str.isEmpty() && !str.equals(" ")) {
                sb.append(str).append(' ');
            }
        }

        return sb.toString().trim();
    }
}