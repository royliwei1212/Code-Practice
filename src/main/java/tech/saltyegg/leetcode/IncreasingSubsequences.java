package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hzhou
 * @since 7/11/17
 */
public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> crt = new ArrayList<>();
        crt.add(new ArrayList<>());

        for (int num : nums) {
            int n = crt.size();

            for (int j = 0; j < n; j++) {
                List<Integer> list = crt.get(j);
                if (list.isEmpty() || num >= list.get(list.size() - 1)) {
                    crt.add(new ArrayList<>(list));
                    list.add(num);
                }

                if (list.size() > 1) {
                    result.add(new ArrayList<>(list));
                }
            }
        }

        return new ArrayList<>(result);
    }
}
