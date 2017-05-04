package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhou on 2015/8/8.
 * Email: i@hzhou.me
 */
public class WordDistance {

    private Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            List<Integer> list;
            if (map.containsKey(s)) {
                list = map.get(s);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(s, list);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int min = Integer.MAX_VALUE;

        for (int a : l1) {
            for (int b : l2) {
                min = Math.min(Math.abs(b - a), min);
            }
        }

        return min;
    }
}
