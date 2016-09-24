package leetcode;

/**
 * archeryue
 * 9/24/16
 */
public class LeetCode112 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return (root != null) && ((sum == root.val && root.left == null && root.right == null)
                || hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }

}
