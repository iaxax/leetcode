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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return _pathSum(root, sum - root.val) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int _pathSum(TreeNode root, int remain) {
        int sum = 0;
        if (root.left != null) {
            sum += _pathSum(root.left, remain - root.left.val);
        }
        if (root.right != null) {
            sum += _pathSum(root.right, remain - root.right.val);
        }
        if (remain == 0) {
            sum += 1;
        }
        return sum;
    }
}
