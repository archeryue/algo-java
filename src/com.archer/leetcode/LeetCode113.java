package com.archer.leetcode;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * archeryue
 * 9/24/16
 */
public class LeetCode113 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Finder finder = new Finder();
        finder.dfs(root, sum);
        return finder.getResult();
    }

    private class Finder {

        private List<List<Integer>> res = new LinkedList<>();
        private List<Integer> stack = new LinkedList<>();

        public boolean dfs(TreeNode node, int sum) {
            if (node == null) {
                return false;
            }

            stack.add(node.val);
            if (node.val == sum && node.left == null && node.right == null) {
                res.add(stack.stream().collect(Collectors.toList()));
            }

            dfs(node.left, sum - node.val);
            dfs(node.right, sum - node.val);
            stack.remove(stack.size() - 1);

            return true;
        }

        public List<List<Integer>> getResult() {
            return res;
        }
    }
}
