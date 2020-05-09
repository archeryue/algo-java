package com.archer.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * archeryue
 * 11/13/16
 */
public class LeetCode95 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new LinkedList<>();
        if (n < 1) return res;

        List<TreeNode> list = new LinkedList<>();
        res.add(new TreeNode(1));
        for (int i = 2; i <= n; i++) {
            list.clear();
            list.addAll(res);
            res.clear();
            for (TreeNode node : list) {
                TreeNode root = new TreeNode(i);
                root.left = newTree(node);
                res.add(root);

                TreeNode p = node;
                TreeNode tmp = new TreeNode(i);
                while (p.right != null) {
                    tmp.left = p.right;
                    p.right = tmp;
                    res.add(newTree(node));
                    p.right = tmp.left;
                    tmp.left = null;
                    p = p.right;
                }
                p.right = tmp;
                res.add(node);
            }
        }
        return res;
    }

    private static TreeNode newTree(TreeNode node) {
        TreeNode copy = new TreeNode(node.val);
        if (node.left != null) {
            copy.left = newTree(node.left);
        }
        if (node.right != null) {
            copy.right = newTree(node.right);
        }
        return copy;
    }

    public static void main(String[] args) {
        generateTrees(5);
    }

}
