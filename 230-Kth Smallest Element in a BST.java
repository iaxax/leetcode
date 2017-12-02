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
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, new int[1], k).val;
    }
    
    private TreeNode inorder(TreeNode root, int[] n, int k) {
        if (root == null) return null;
        TreeNode left = inorder(root.left, n, k);
        if (left != null) return left;
        if (++n[0] == k) return root;
        return inorder(root.right, n, k);
    }
}
