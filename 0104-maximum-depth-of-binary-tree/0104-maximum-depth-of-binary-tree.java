/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return maxD(root);
    }

    private int maxD(TreeNode root) {
        if (root == null) return 0;
        int leftsum = maxD(root.left);
        int rightsum = maxD(root.right);
        return Math.max(leftsum, rightsum) + 1;
    }
}