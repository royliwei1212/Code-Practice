package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hzhou
 * @since 9/14/17
 */
public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        Map<String, Set<Character>> map = new HashMap<>(26);

        for (String s : words) {
            map.put(s, new HashSet<>());
            for (char c : s.toCharArray()) {
                map.get(s).add(c);
            }
        }

        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            Set<Character> si = map.get(words[i]);
            for (int j = i + 1; j < words.length; j++) {
                boolean shouldBreak = false;
                for (char c : map.get(words[j])) {
                    if (si.contains(c)) {
                        shouldBreak = true;
                        break;
                    }
                }
                if (!shouldBreak) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }

        return result;
    }
}
