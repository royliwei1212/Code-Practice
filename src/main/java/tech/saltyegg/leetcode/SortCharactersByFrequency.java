package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hzhou
 * @since 9/15/17
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : s.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(dict.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : list) {
            int count = e.getValue();
            while (count > 0) {
                sb.append(e.getKey());
                count--;
            }
        }
        return sb.toString();
    }
}
