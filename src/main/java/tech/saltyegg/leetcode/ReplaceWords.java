package tech.saltyegg.leetcode;

import java.util.*;

public class ReplaceWords {

    public String replaceWords(List<String> dict, String sentence) {
        dict.sort(Comparator.comparingInt(String::length));
        String[] arr = sentence.split(" ");

        Map<Character, List<String>> map = new HashMap<>();
        for (String s : dict) {
            char c = s.charAt(0);
            List<String> l = map.getOrDefault(c, new ArrayList<>());
            l.add(s);
            map.put(c, l);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);
            if (map.containsKey(c)) {
                List<String> list = map.get(c);
                for (String s : list) {
                    if (arr[i].startsWith(s)) {
                        arr[i] = s;
                        break;
                    }
                }
            }
            sb.append(arr[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
