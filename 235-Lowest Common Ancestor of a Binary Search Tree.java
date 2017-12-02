/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == null) return q;
        if (q == null) return p;
        return _lowestCommonAncestor(root, p, q);
    }
    
    private TreeNode _lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rVal = root.val;
        int minVal = Math.min(p.val, q.val);
        int maxVal = Math.max(p.val, q.val);
        if (minVal <= rVal && maxVal >= rVal) {
            return root;
        
        }
        if (minVal > rVal) {
            return _lowestCommonAncestor(root.right, p, q);
        }
        else {
            return _lowestCommonAncestor(root.left, p, q);
        }
    }
}
