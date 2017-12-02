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
    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];
        sum(root, tilt);
        return tilt[0];
    }
    
    private int sum(TreeNode root, int[] tilt) {
        if (root == null) return 0;
        int l = sum(root.left, tilt);
        int r = sum(root.right, tilt);
        tilt[0] += Math.abs(l - r);
        return l + r + root.val;
    }
}
