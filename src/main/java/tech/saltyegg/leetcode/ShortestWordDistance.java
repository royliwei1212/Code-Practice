package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhou on 2015/8/8.
 * Email: i@hzhou.me
 */
public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> dp = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (!dp.containsKey(s)) {
                dp.put(s, new ArrayList<>());
            }
            dp.get(s).add(i);
        }
        int result = words.length;
        for (int i : dp.get(word1)) {
            for (int j : dp.get(word2)) {
                result = Math.min(result, Math.abs(i - j));
            }
        }
        return result;
    }
}
