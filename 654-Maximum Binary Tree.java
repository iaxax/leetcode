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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMBT(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMBT(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIndex = start;
        for (int i = start + 1; i <= end; ++i) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMBT(nums, start, maxIndex - 1);
        root.right = constructMBT(nums, maxIndex + 1, end);
        return root;
    }
}
