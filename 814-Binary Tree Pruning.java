/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root != null) {
            TreeNode left = pruneTree(root.left);
            TreeNode right = pruneTree(root.right);
            if (root.val == 0 && left == null && right == null) {
                return null;
            }
            root.left = left;
            root.right = right;
        }
        return root;
    }
}