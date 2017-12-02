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
    public int rob(TreeNode root) {
        int[] result = _rob(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] _rob(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = _rob(root.left);
        int[] right = _rob(root.right);
        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
