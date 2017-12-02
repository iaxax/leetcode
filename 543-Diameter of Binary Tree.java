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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        getHeight(root, max);
        return max[0];
    }
    
    private int getHeight(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = getHeight(root.left, max);
        int right = getHeight(root.right, max);
        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right) + 1;
    }
}
