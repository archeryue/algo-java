package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * archeryue
 * 10/1/16
 */
public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        innerTraversal(res, root);
        return res;
    }

    private void innerTraversal(List<Integer> list, TreeNode node) {
        if (node == null) return;
        innerTraversal(list, node.left);
        list.add(node.val);
        innerTraversal(list, node.right);
    }

    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

}
