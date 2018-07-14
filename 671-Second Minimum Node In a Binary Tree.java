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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return findSecondMinimumValue(root, root.val);
    }

    private int findSecondMinimumValue(TreeNode root, int val) {
        if (root == null) return -1;
        if (root.val > val) return root.val;
        
        int left = findSecondMinimumValue(root.left, val);
        int right = findSecondMinimumValue(root.right, val);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}
