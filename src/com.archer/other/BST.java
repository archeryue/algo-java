/**
 * @(#)BST.java, May 20, 2020.
 * <p>
 * Copyright 2020 archer.com. All rights reserved.
 * ARCHER.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.archer.other;

/**
 * Archer Yue
 * 2020/5/20
 */
public class BST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBST(TreeNode root) {
        return innerSearch(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean innerSearch(TreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.val < min || node.val > max) return false;
        return innerSearch(node.left, min, node.val) && innerSearch(node.right, node.val, max);
    }
}