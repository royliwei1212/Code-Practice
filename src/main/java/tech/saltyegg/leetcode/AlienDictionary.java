package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by hzhou on 2016/5/8.
 * Email: i@hzhou.me
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        if (words.length == 1) {
            return words[0];
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> toCount = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        init(graph, toCount, words);
        process(graph, toCount, words);
        build(sb, graph, toCount);
        return sb.length() == toCount.size() ? sb.toString() : "";
    }

    private void init(Map<Character, Set<Character>> graph, Map<Character, Integer> toCount, String[] words) {
        Arrays.stream(words).forEach(word -> {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                toCount.putIfAbsent(c, 0);
            }
        });
    }

    private void process(Map<Character, Set<Character>> graph, Map<Character, Integer> toCount, String[] words) {
        Set<String> edges = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            // TODO: what if s1 or s2 is null
            for (int j = 0; j < s1.length() && j < s2.length(); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    continue;
                }
                String edge = "" + c1 + c2;
                if (!edges.contains(edge)) {
                    toCount.put(c2, toCount.get(c2) + 1);
                    Set<Character> val = graph.get(c1);
                    val.add(c2);
                    graph.put(c1, val);
                    edges.add(edge);
                    break;
                }
            }
        }
    }

    private void build(StringBuilder sb, Map<Character, Set<Character>> graph, Map<Character, Integer> toCount) {
        Queue<Character> queue = new LinkedList<>();
        toCount.forEach((key, value) -> {
            if (value == 0) {
                queue.add(key);
            }
        });

        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            graph.get(c).forEach(ch -> {
                int value = toCount.get(ch) - 1;
                toCount.put(ch, value);
                if (value == 0) {
                    queue.add(ch);
                }
            });
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        AlienDictionary ad = new AlienDictionary();
        System.out.println(ad.alienOrder(words));
    }

}
