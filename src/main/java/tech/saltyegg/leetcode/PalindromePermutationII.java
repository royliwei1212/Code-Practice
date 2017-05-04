package tech.saltyegg.leetcode;

import java.util.*;

/**
 * Created by hzhou on 5/4/16.
 * Email: i@hzhou.me
 */
public class PalindromePermutationII {

    public List<String> generatePalindromes(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> map = getCountMap(s);
        if (!isPermutable(map)) {
            return Collections.emptyList();
        }

        Character center = getMiddleChar(map);

        List<Character> half = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue() / 2; i++) {
                half.add(entry.getKey());
            }
        }
        Set<String> halfResult = new HashSet<>();
        getAllString(halfResult, half, new boolean[half.size()], new StringBuilder());

        List<String> result = new ArrayList<>();
        halfResult.forEach(str -> result.add(str + (center == null ? "" : center) + new StringBuilder(str).reverse()));

        return result;
    }

    private void getAllString(Set<String> result, List<Character> half, boolean[] isVisited, StringBuilder sb) {
        if (sb.length() == half.size()) {
            result.add(sb.toString());
        }
        for (int i = 0; i < half.size(); i++) {
            if (!isVisited[i]) {
                StringBuilder tmp = new StringBuilder(sb);
                tmp.append(half.get(i));
                isVisited[i] = true;
                getAllString(result, half, isVisited, tmp);
                isVisited[i] = false;
            }

        }
    }

    private Map<Character, Integer> getCountMap(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int val = 1;
            if (map.containsKey(c)) {
                val += map.get(c);
            }
            map.put(c, val);
        }
        return map;
    }

    private boolean isPermutable(Map<Character, Integer> map) {
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                count++;
            }
        }
        return count < 2;
    }

    private Character getMiddleChar(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PalindromePermutationII pp = new PalindromePermutationII();
        System.out.println(pp.generatePalindromes("aabb"));
    }

}
