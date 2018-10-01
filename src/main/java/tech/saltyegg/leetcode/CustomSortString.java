package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        Character[] arr = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            arr[i] = T.charAt(i);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> map.getOrDefault(o, 0)));

        StringBuilder sb = new StringBuilder();
        for (char c : arr) sb.append(c);
        return sb.toString();
    }
}
