package tech.saltyegg.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Preference {
    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(3, 5, 7, 9));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 3, 8));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5, 8));
        List<List<Integer>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(list3);
        List<Integer> result = getPreference(input);
        for (Integer aResult : result) {
            System.out.print(aResult + ",");
        }
    }

    public static List<Integer> getPreference(List<List<Integer>> prefers) {
        List<Integer> result = new ArrayList<>();
        //如果有平手出现，就按照入queue的顺序，那么edges中的用List就比较好，因为它维持顺序，或者 LinkedHashSet也可以
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (List<Integer> list : prefers) {
            for (int i = 0; i < list.size() - 1; i++) {
                int from = list.get(i);
                int to = list.get(i + 1);
                //indegree要包含from节点，否则下面BFS无从开始！
                inDegrees.putIfAbsent(from, 0);
                inDegrees.put(to, inDegrees.getOrDefault(to, 0) + 1);
                edges.putIfAbsent(from, new ArrayList<>());
                edges.get(from).add(to);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            int head = queue.poll();
            result.add(head);
            if (edges.containsKey(head)) {
                for (int next : edges.get(head)) {
                    inDegrees.put(next, inDegrees.get(next) - 1);
                    if (inDegrees.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return result;
    }
}
