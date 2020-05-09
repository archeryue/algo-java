package com.archer.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * archeryue
 * 11/15/16
 */
public class LeetCode133 {

    // Definition for undirected graph.
    private class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        node.neighbors.forEach(n -> newNode.neighbors.add(cloneGraph(n)));
        return newNode;
    }

}
