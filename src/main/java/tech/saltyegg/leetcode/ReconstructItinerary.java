package tech.saltyegg.leetcode;

import java.util.*;

/**
 * Created by hzhou on 2016/5/18.
 * Email: i@hzhou.me
 */
public class ReconstructItinerary {

    private String start = "JFK";

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) {
            return Collections.emptyList();
        }

        Map<String, Set<Path>> map = new HashMap<>();
        for (String[] t : tickets) {
            Path path = new Path(t[0], t[1]);
            Set<Path> set = map.get(path.from) == null ? new HashSet<>() : map.get(path.from);
            set.add(path);
            map.put(t[0], set);
        }

        List<String> result = new LinkedList<>();
        List<String> crt = new LinkedList<>();
        crt.add(start);
        process(start, map, new HashSet<>(), crt, result, tickets.length + 1);
        return result;
    }

    private void process(String start, Map<String, Set<Path>> map, Set<Path> visited, List<String> crt, List<String> result, int length) {
        if (crt.size() == length) {
            if (isSmaller(crt, result)) {
                result.clear();
                result.addAll(crt);
            }
            return;
        }
        Set<Path> set = map.get(start);
        if (set == null) return;
        for (Path p : set) {
            if (!visited.contains(p)) {
                crt.add(p.to);
                visited.add(p);
                process(p.to, map, visited, crt, result, length);
                visited.remove(p);
                crt.remove(crt.size() - 1);
            }
        }
    }

    private boolean isSmaller(List<String> crt, List<String> result) {
        if (result.isEmpty()) {
            return true;
        }
        for (int i = 0; i < crt.size(); i++) {
            if (crt.get(i).compareTo(result.get(i)) < 0) {
                return true;
            } else if (crt.get(i).compareTo(result.get(i)) > 0) {
                return false;
            }
        }
        return false;
    }

    private static class Path {
        String from;
        String to;

        Path(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Path path = (Path) o;

            return from != null ? from.equals(path.from) : path.from == null && (to != null ? to.equals(path.to) : path.to == null);

        }

        @Override
        public int hashCode() {
            int result = from != null ? from.hashCode() : 0;
            result = 31 * result + (to != null ? to.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        //String[][] tickets = new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] tickets = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        ReconstructItinerary ri = new ReconstructItinerary();
        List<String> result = ri.findItinerary(tickets);
        System.out.println(result);
    }

}
