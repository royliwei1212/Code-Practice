package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hzhou
 * @since 5/20/17
 */
public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);
        }
        int size = set.size();
        return size > candies.length / 2 ? candies.length / 2 : size;
    }
}
