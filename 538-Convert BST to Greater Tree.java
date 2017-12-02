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
    public TreeNode convertBST(TreeNode root) {
        reverseInorder(root, 0);
        return root;
    }
    
    private int reverseInorder(TreeNode root, int sum) {
        if (root == null) return sum;
        int s = reverseInorder(root.right, sum);
        root.val += s;
        return reverseInorder(root.left, root.val);
    }
}
