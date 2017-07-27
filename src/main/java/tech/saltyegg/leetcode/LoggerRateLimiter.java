package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    private Map<String, Integer> cache;

    public LoggerRateLimiter() {
        cache = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int time = cache.getOrDefault(message, -100);
        if (timestamp - time >= 10) {
            cache.put(message, timestamp);
            return true;
        }

        return false;
    }
}
