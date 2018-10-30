package tech.saltyegg.leetcode;

import java.util.*;

public class FindAndReplaceInString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int pre = 0;
        List<String> list = new ArrayList<>();
        Set<Integer> skipped = new HashSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < indexes.length; i++) map.put(indexes[i], i);

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int i = e.getValue();
            if (S.indexOf(sources[i], e.getKey()) != e.getKey()) {
                skipped.add(i);
                continue;
            }
            String sub = S.substring(pre, e.getKey());
            list.add(sub);
            pre = e.getKey() + sources[i].length();

        }
        list.add(S.substring(pre));
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int i = e.getValue();
            if (skipped.contains(i)) continue;
            sb.append(list.get(start++)).append(targets[i]);
        }
        sb.append(list.get(start));
        return sb.toString();
    }

    public String findReplaceString2(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(S);
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < indexes.length; ++i) {
            tm.put(indexes[i], i);
        }
        for (int key : tm.descendingKeySet()) {
            int i = tm.get(key);
            if (S.indexOf(sources[i], indexes[i]) == indexes[i]) {
                sb.replace(indexes[i], indexes[i] + sources[i].length(), targets[i]);
            }
        }
        return sb.toString();
    }

}
