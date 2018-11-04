package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> eMap = new HashMap<>();
        Map<String, List<Double>> vMap = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0], b = equations[i][1];
            eMap.putIfAbsent(a, new ArrayList<>());
            eMap.putIfAbsent(b, new ArrayList<>());
            vMap.putIfAbsent(a, new ArrayList<>());
            vMap.putIfAbsent(b, new ArrayList<>());

            eMap.get(a).add(b);
            eMap.get(b).add(a);
            vMap.get(a).add(values[i]);
            vMap.get(b).add(1.0 / values[i]);
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = helper(eMap, vMap, queries[i][0], queries[i][1], new HashSet<>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }

    private double helper(Map<String, List<String>> eMap, Map<String, List<Double>> vMap, String start, String end, Set<String> visited, double value) {
        if (visited.contains(start) || !eMap.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;

        visited.add(start);
        List<String> nextStr = eMap.get(start);
        List<Double> nextVal = vMap.get(start);
        double result = 1.0;
        for (int i = 0; i < nextStr.size(); i++) {
            result = helper(eMap, vMap, nextStr.get(i), end, visited, value * nextVal.get(i));
            if (result != 0.0) break;
        }

        visited.remove(start);
        return result;
    }

    public double[] calcEquation2(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] e = equations[i];
            double v = values[i];
            map.putIfAbsent(e[0], new HashMap<>());
            map.putIfAbsent(e[1], new HashMap<>());
            map.get(e[0]).put(e[1], v);
            map.get(e[1]).put(e[0], 1 / v);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] q = queries[i];
            if (!map.containsKey(q[0]) || !map.containsKey(q[1])) {
                result[i] = -1;
                continue;
            }
            result[i] = helper(map, new HashSet<>(), q[0], q[1], 1);
            if (result[i] == 0) result[i] = -1;
        }

        return result;
    }

    private double helper(Map<String, Map<String, Double>> map, Set<String> visited, String start, String end, double r) {
        if (visited.contains(start)) return 0;
        if (start.equals(end)) {
            return r;
        }
        double result = 0;
        visited.add(start);
        for (Map.Entry<String, Double> e : map.get(start).entrySet()) {
            result = helper(map, visited, e.getKey(), end, r * e.getValue());
            if (result != 0) break;
        }
        visited.remove(start);
        return result;
    }
}
