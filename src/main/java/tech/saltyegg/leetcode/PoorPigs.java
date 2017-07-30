package tech.saltyegg.leetcode;

public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int round = minutesToTest / minutesToDie;
        return (int) Math.ceil(Math.log(buckets) / Math.log(round + 1));
    }

}
