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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode head = new TreeNode(0);
        head.left = root;
        
        TreeNode current = root;
        TreeNode pre = head;
        while (current != null) {
            if (current.val < key) {
                pre = current;
                current = current.right;
            } else if (current.val > key) {
                pre = current;
                current = current.left;
            } else break;
        }
        
        if (current != null) {
            if (current.right == null) {
                if (pre.left == current) {
                    pre.left = current.left;
                } else if (pre.right == current) {
                    pre.right = current.left;
                }
            } else {
                TreeNode node = current, p = current;
                current = current.right;
                while (current.left != null) {
                    p = current;
                    current = current.left;
                }
                
                node.val = current.val;
                if (p == node) {
                    p.right = current.right;
                } else if (p.left == current) {
                    p.left = current.right;
                }
            }
        }
        
        return head.left;
    }
}
