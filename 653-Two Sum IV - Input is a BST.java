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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> serialize = new ArrayList<>(100);
        inorder(root, serialize);
        int left = 0, right = serialize.size() - 1;
        while (left < right) {
            int sum = serialize.get(left) + serialize.get(right);
            if (sum == k) return true;
            if (sum < k) ++left;
            else --right;
        }
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
