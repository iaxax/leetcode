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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new LinkedList<String>();
        List<String> result = new LinkedList<>();
        getPath(root, result, new LinkedList<>());
        return result;
    }
    
    private void getPath(TreeNode root, List<String> result, List<TreeNode> path) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode node : path) {
                sb.append(String.valueOf(node.val)).append("->");
            }
            result.add(sb.append(String.valueOf(root.val)).toString());
            return;
        }
        
        if (root.left != null) {
            path.add(root);
            getPath(root.left, result, path);
            path.remove(path.size() - 1);
        }
        
        if (root.right != null) {
            path.add(root);
            getPath(root.right, result, path);
            path.remove(path.size() - 1);
        }
    }
}
