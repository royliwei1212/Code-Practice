package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class GeneralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {
        if (word == null || word.isEmpty()) return Collections.singletonList("");
        List<String> result = new ArrayList<>();
        result.add(word);
        helper(0, result, word);
        return result;
    }

    private void helper(int start, List<String> result, String word) {
        for (int i = start; i < word.length(); i++) {
            for (int j = 1; j + i <= word.length(); j++) {
                String s = word.substring(0, i) + j + word.substring(i + j);
                result.add(s);
                helper(i + String.valueOf(j).length() + 1, result, s);
            }
        }
    }
}
