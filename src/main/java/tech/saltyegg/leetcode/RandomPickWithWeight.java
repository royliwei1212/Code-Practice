package tech.saltyegg.leetcode;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {

    private Random rand;
    private TreeMap<Integer, Integer> map;
    private int sum;

    public RandomPickWithWeight(int[] w) {
        rand = new Random();
        map = new TreeMap<>();
        sum = 0;
        for (int i = 0; i < w.length; i++) {
            map.put(sum, i);
            sum += w[i];
        }
    }

    public int pickIndex() {
        int key = (int) (sum * rand.nextFloat());
        return map.floorEntry(key).getValue();
    }
}
