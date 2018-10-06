package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhou on 2015/5/28. Email: codeashobby@gmail.com
 * <p/>
 * // Note: leetcode test says words can have duplicated items
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) return result;

        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);

        int sl = words[0].length();
        int tl = sl * words.length;

        for (int i = 0; i <= s.length() - tl; i++) {
            String sub = s.substring(i, i + sl);
            if (!map.containsKey(sub)) continue;
            if (helper(s.substring(i, i + tl), sl, map)) result.add(i);
        }
        return result;
    }

    private boolean helper(String s, int len, Map<String, Integer> map) {
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i += len) {
            String sub = s.substring(i, i + len);
            if (!map.containsKey(sub)) return false;
            int c = count.getOrDefault(sub, 0) + 1;
            if (c > map.get(sub)) return false;
            count.put(sub, c);
        }
        return true;
    }
}
