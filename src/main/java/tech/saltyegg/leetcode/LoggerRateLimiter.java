package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LoggerRateLimiter {

    private int[] bucket;
    private Set[] set;

    public LoggerRateLimiter() {
        bucket = new int[10];
        set = new Set[10];
        for (int i = 0; i < 10; i++) {
            set[i] = new HashSet();
        }
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int ts = timestamp % 10;
        if (timestamp != bucket[ts]) {
            set[ts].clear();
            bucket[ts] = timestamp;
        }
        for (int i = 0; i < 10; i++) {
            if (timestamp - bucket[i] < 10 && set[i].contains(message)) {
                return false;
            }
        }

        set[ts].add(message);
        return true;
    }
}
