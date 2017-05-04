package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 2/26/17
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        return word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase());
    }
}
