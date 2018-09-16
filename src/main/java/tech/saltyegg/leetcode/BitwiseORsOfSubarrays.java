package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> crt = new HashSet<>();

        for (int i : A) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            for (Integer c : crt) {
                set.add(c | i);
            }
            crt = set;
            result.addAll(set);
        }
        return result.size();
    }
}
