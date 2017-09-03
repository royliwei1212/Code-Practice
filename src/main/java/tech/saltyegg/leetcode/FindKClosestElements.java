package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzhou
 * @since 9/3/17
 */
public class FindKClosestElements {

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        if (k == 0) return result;

        int start = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            int a = arr.get(i);
            if (Math.abs(a - x) < min) {
                min = Math.abs(a - x);
                start = i;
            }
        }

        result.add(arr.get(start));
        int be = start - 1;
        int af = start + 1;
        while (result.size() < k) {
            if (be < 0) {
                result.add(arr.get(af++));
                continue;
            }

            if (af >= arr.size()) {
                result.add(0, arr.get(be--));
                continue;
            }

            int before = arr.get(be);
            int after = arr.get(af);
            if (x - before <= after - x) {
                result.add(0, before);
                be--;
            } else {
                result.add(after);
                af++;
            }
        }

        return result;
    }

}
