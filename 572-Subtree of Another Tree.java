/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// O(n^2) Solution
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null && t != null || s != null && t == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null && t != null || s != null && t == null) return false;
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    
}

// O(n) Solution
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sb1 = new StringBuilder(200);
        serialize(s, sb1);
        StringBuilder sb2 = new StringBuilder(200);
        serialize(t, sb2);
        return sb1.toString().contains(sb2.toString());
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",#"); return;
        }
        sb.append(",").append(root.val);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
}
