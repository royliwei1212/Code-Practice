package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            int w = wage[i];
            double q = quality[i];
            list.add(new Pair(w / q, q));
        }
        list.sort(Comparator.comparingDouble(o -> o.ratio));

        PriorityQueue<Double> pq = new PriorityQueue<>();
        double result = Double.MAX_VALUE;
        double qsum = 0;
        for (Pair p : list) {
            qsum += p.quality;
            pq.add(-p.quality);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) result = Math.min(result, p.ratio * qsum);
        }
        return result;
    }

    static class Pair {
        double ratio;
        double quality;

        Pair(double ratio, double quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }
}
