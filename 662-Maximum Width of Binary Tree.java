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
    
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q = new LinkedList<>();
        if (root != null) q.offer(new Pair(root, 0));
        
        int width = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            width = Math.max(width, q.peekLast().position - q.peekFirst().position + 1);
            for (int i = 0; i < size; ++i) {
                Pair p = q.poll();
                TreeNode n = p.node;
                if (n.left != null) q.offer(new Pair(n.left, p.position * 2));
                if (n.right != null) q.offer(new Pair(n.right, p.position * 2 + 1));
            }
        }
        return width;
    }
    
    private class Pair {
        TreeNode node;
        int position;
        Pair(TreeNode n, int p) {
            node = n;
            position = p;
        }
    }
}
