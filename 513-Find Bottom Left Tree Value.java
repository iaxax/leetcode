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
    public int findBottomLeftValue(TreeNode root) {
        int value = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            value = q.peek().val;
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        
        return value;
    }
}
