package com.archer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * archeryue
 * 11/15/16
 */
public class LeetCode138 {

    private class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public class Solution {

        Map<Integer, RandomListNode> map = new HashMap<>();

        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;
            if (map.containsKey(head.label)) return map.get(head.label);
            RandomListNode node = new RandomListNode(head.label);
            map.put(node.label, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            return node;
        }
    }

}
