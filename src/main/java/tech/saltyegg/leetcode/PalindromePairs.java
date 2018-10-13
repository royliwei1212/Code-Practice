package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hzhou on 2016/5/22.
 * Email: i@hzhou.me
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) return result;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);

        for (int k = 0; k < words.length; k++) {
            String w = words[k];
            String rw = r(w);
            if (!w.isEmpty() && ip(w) && map.containsKey("")) {
                result.add(Arrays.asList(k, map.get("")));
                result.add(Arrays.asList(map.get(""), k));
            }
            if (!rw.equals(w) && map.containsKey(rw)) {
                result.add(Arrays.asList(k, map.get(rw)));
            }

            for (int i = 1; i < w.length(); i++) {
                String l = w.substring(0, i);
                String r = w.substring(i);

                String rl = r(l);
                String rr = r(r);

                if (ip(l) && map.containsKey(rr)) result.add(Arrays.asList(map.get(rr), k));
                if (ip(r) && map.containsKey(rl)) result.add(Arrays.asList(k, map.get(rl)));
            }
        }

        return result;
    }

    private boolean ip(String s) {
        return r(s).equals(s);
    }

    private String r(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
}
