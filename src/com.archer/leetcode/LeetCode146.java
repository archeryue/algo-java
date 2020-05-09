package com.archer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * archeryue
 * 11/15/16
 */
public class LeetCode146 {

    public class LRUCache {

        private class Node {
            int key;
            int val;
            Node pre;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private Map<Integer, Node> cache;
        private Node head;
        private Node tail;
        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            updateLRU(node);
            return node.val;
        }

        public void set(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                if (cache.size() == capacity) {
                    cache.remove(tail.pre.key);
                    delete(tail.pre);
                }
                Node newNode = new Node(key, value);
                add(newNode);
                cache.put(key, newNode);
            } else {
                node.val = value;
                updateLRU(node);
            }
        }

        private void updateLRU(Node node) {
            delete(node);
            add(node);
        }

        private void add(Node node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        private void delete(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
        }
    }
}
