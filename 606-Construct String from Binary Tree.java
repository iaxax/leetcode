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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        tree2str(t, sb);
        return sb.toString();
    }
    
    private void tree2str(TreeNode t, StringBuilder sb) {
        sb.append(t.val);
        if (t.left != null) {
            sb.append("(");
            tree2str(t.left, sb);
            sb.append(")");
        }
        if (t.right != null) {
            if (t.left == null) {
                sb.append("()");
            }
            sb.append("(");
            tree2str(t.right, sb);
            sb.append(")");
        }
    }
}
