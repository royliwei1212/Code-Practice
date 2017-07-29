package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            m1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            m2.put(list2[i], i);
        }

        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            if (m2.containsKey(entry.getKey())) {
                m1.put(entry.getKey(), entry.getValue() + m2.get(entry.getKey()));
            } else {
                m1.put(entry.getKey(), Integer.MAX_VALUE);
            }
        }
        int minValue = m1.values().stream().mapToInt(Integer::intValue).min().orElse(-1);
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : m1.entrySet()) {
            if (entry.getValue() == minValue) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[result.size()]);
    }

}
