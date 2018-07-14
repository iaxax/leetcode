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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        
        int path = longestUnivaluePath(root.left, root.val) + longestUnivaluePath(root.right, root.val);
        path = Math.max(path, longestUnivaluePath(root.left));
        path = Math.max(path, longestUnivaluePath(root.right));
        return path;
    }
    
    private int longestUnivaluePath(TreeNode root, int val) {
        if (root == null || root.val != val) return 0;
        return 1 + Math.max(longestUnivaluePath(root.left, val), longestUnivaluePath(root.right, val));
    }
}
