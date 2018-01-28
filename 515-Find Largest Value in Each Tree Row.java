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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            int largest = q.peek().val;
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                if (node.val > largest) largest = node.val;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(largest);
        }
        return result;
    }
}
