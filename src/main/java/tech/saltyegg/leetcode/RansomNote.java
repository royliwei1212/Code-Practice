package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (counter.getOrDefault(c, 0) <= 0) {
                return false;
            } else {
                counter.put(c, counter.get(c) - 1);
            }
        }
        return true;
    }
}
