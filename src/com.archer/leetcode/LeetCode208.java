package com.archer.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * archeryue
 * 9/19/16
 */
public class LeetCode208 {

    private TrieNode root;

    public LeetCode208() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = innerInsert(node, ch);
        }
        node.setFin(true);
    }

    private TrieNode innerInsert(TrieNode node, char ch) {
        TrieNode child = innerSearch(node, ch);
        if (child == null) {
            child = new TrieNode(ch);
            node.addChild(child);
        }
        return child;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = innerSearch(node, ch);
            if (child == null) {
                return false;
            }
            node = child;
        }
        return node.isFin();
    }

    private TrieNode innerSearch(TrieNode node, char ch) {
        for (TrieNode child : node.getChildren()) {
            if (child.getVal() == ch) {
                return child;
            }
        }
        return null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode child = innerSearch(node, ch);
            if (child == null) {
                return false;
            }
            node = child;
        }
        return node.isFin() || node.getChildren().size() > 0;
    }

    private class TrieNode {
        // Initialize your data structure here.
        private char val;
        private boolean fin;
        private List<TrieNode> children;

        public TrieNode() {
            this(' ');
        }

        public TrieNode(char val) {
            this.val = val;
            this.children = new LinkedList<>();
        }

        public void setFin(boolean fin) {
            this.fin = fin;
        }

        public boolean isFin() {
            return this.fin;
        }

        public char getVal() {
            return this.val;
        }

        public void addChild(TrieNode child) {
            this.children.add(child);
        }

        public List<TrieNode> getChildren() {
            return this.children;
        }
    }

}
