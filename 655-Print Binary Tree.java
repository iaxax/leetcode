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
    public List<List<String>> printTree(TreeNode root) {
        int m = height(root);
        int n = (1 << m) - 1;
        
        String[][] matrix = new String[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = "";
            }
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 0; i < m; ++i) {
            int size = q.size();
            int gap = 1 << (m - 1 - i), index = -1;
            for (int j = 0; j < size; ++j) {
                index += gap;
                TreeNode node = q.poll();
                if (node != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                    matrix[i][index] = String.valueOf(node.val);
                } else {
                    q.offer(null);
                    q.offer(null);
                    matrix[i][index] = "";
                }
                index += gap;
            }
            
        }
        
        List<List<String>> result = new ArrayList<>(m);
        for (int i = 0; i < m; ++i) {
            List<String> list = new ArrayList<>(n);
            for (int j = 0; j < n; ++j) {
                list.add(matrix[i][j]);
            }
            result.add(list);
        }
        return result;
    }
    
    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
