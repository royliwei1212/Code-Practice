package tech.saltyegg.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * Created by hzhou on 2015/8/8.
 * Email: i@hzhou.me
 */
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {

        assert strings != null : "null array";

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String code = getFeatureCode(s);
            List<String> val;
            if (!map.containsKey(code)) {
                val = new ArrayList<>();
            } else {
                val = map.get(code);
            }
            val.add(s);
            map.put(code, val);
        }

        for (String key : map.keySet()) {
            List<String> val = map.get(key);
            Collections.sort(val);
            result.add(val);
        }

        return result;

    }

    private String getFeatureCode(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 1; i < s.length(); i++) {
            int tmp = ((s.charAt(i) - s.charAt(i - 1)) + 26) % 26;
            sb.append(tmp).append("#");
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String[] strs = new String[]{"az", "yx"};
        groupStrings(strs);
    }

}
