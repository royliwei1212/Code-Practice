package tech.saltyegg.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by hzhou on 2016/5/18.
 */
public class ReconstructItineraryNew {

    private LinkedList<String> result;
    private Map<String, PriorityQueue<String>> map;

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return Collections.emptyList();
        }

        result = new LinkedList<>();
        map = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).add(ticket[1]);
        }
        dfs("JFK");
        return result;
    }

    private void dfs(String start) {
        while (map.containsKey(start) && !map.get(start).isEmpty()) {
            dfs(map.get(start).poll());
        }
        result.addFirst(start);
    }

}
