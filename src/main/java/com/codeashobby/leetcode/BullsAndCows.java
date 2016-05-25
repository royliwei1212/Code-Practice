package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/24.
 * Email: i@hzhou.me
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int bull = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        int cow = 0;
        List<Character> gList = new ArrayList<>();
        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if (a == b) {
                bull++;
            } else {
                gList.add(b);
                int value = sMap.containsKey(a) ? sMap.get(a) + 1 : 1;
                sMap.put(a, value);
            }
        }

        for (Character c : gList) {
            if (sMap.containsKey(c)) {
                cow++;
                int count = sMap.get(c);
                if (count == 1) {
                    sMap.remove(c);
                } else {
                    sMap.put(c, count - 1);
                }
            }
        }

        return bull + "A" + cow + "B";
    }

}
