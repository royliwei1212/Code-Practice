package tech.saltyegg.leetcode;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by hzhou on 2016/5/8.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        if (words.length == 1) return words[0];

        Set<Character> allChars = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<Character, Character>> set = new HashSet<>();

        for (String w : words) {
            for (char c : w.toCharArray()) allChars.add(c);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String crt = words[i];
            String next = words[i + 1];
            int min = Math.min(crt.length(), next.length());
            int k = 0;
            while (k < min && crt.charAt(k) == next.charAt(k)) {
                k++;
            }
            if (k < min) set.add(new AbstractMap.SimpleEntry<>(crt.charAt(k), next.charAt(k)));
            if (k == min && crt.length() > next.length()) return "";
        }

        int[] cnt = new int[256];
        for (Map.Entry<Character, Character> e : set) {
            cnt[e.getValue() - 'a']++;
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : allChars) {
            if (cnt[c - 'a'] == 0) {
                queue.add(c);
                sb.append(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();

            for (Map.Entry<Character, Character> e : set) {
                char key = e.getKey();
                char val = e.getValue();

                if (key == c) {
                    cnt[val - 'a']--;
                    if (cnt[val - 'a'] == 0) {
                        queue.add(val);
                        sb.append(val);
                    }
                }
            }
        }

        return sb.length() == allChars.size() ? sb.toString() : "";
    }

}
