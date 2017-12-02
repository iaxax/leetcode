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
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;
        int diff = Integer.MAX_VALUE;
        while (current != null || !stack.isEmpty()) {
            if (current != null && current.left != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                if (current == null)
                    current = stack.pop();
                if (pre != null) 
                    diff = Math.min(diff, current.val - pre.val);
                pre = current;
                current = current.right;
            }
        }
        return diff;
    }
}
