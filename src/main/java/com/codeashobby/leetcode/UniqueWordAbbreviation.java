package com.codeashobby.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hzhou on 2016/5/3.
 * Email: i@hzhou.me
 */
public class UniqueWordAbbreviation {

    private Map<String, Integer> map = new HashMap<>();
    private Set<String> input;

    public UniqueWordAbbreviation(String[] dictionary) {

        input = Arrays.stream(dictionary)
                .filter(d -> (d != null && !d.isEmpty()))
                .collect(Collectors.toSet());

        for (String s : input) {
            if (s == null) {
                continue;
            }
            int val = 1;
            String abbr = toAbbr(s);
            if (map.containsKey(abbr)) {
                val += map.get(abbr);
            }
            map.put(abbr, val);
        }

    }

    public boolean isUnique(String word) {
        if (word == null) {
            return false;
        }
        String abbr = toAbbr(word);
        return !map.containsKey(abbr) || (map.get(abbr) == 1 && input.contains(word));
    }

    private String toAbbr(String s) {
        if (s == null || s.length() < 3) {
            return s;
        } else {
            return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
        }

    }

    public static void main(String[] args) {
        UniqueWordAbbreviation uwa = new UniqueWordAbbreviation(new String[]{"dog"});
        System.out.println(uwa.isUnique("dig"));
        System.out.println(uwa.isUnique("dug"));
        System.out.println(uwa.isUnique("dag"));
        System.out.println(uwa.isUnique("dog"));
        System.out.println(uwa.isUnique("doge"));
    }
}
