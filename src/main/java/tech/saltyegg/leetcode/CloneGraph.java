/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Description: Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * @author hzhou
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

        queue.add(node);
        map.put(node, newHead);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();

            for (UndirectedGraphNode n : curr.neighbors) {
                if (!map.containsKey(n)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(n.label);
                    map.put(n, copy);
                    queue.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return newHead;
    }
}