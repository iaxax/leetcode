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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return root;
        
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < d - 1; ++i) {
            int size = q.size();
            for (int j = 0; j < size; ++j) {
                TreeNode n = q.poll();
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
        }
        
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            TreeNode l = new TreeNode(v), r = new TreeNode(v);
            l.left = n.left;
            r.right = n.right;
            n.left = l;
            n.right = r;
        }
        return root;
    }
}
