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
    public int[] findMode(TreeNode root) {
        // states[0]:currentValue, states[1]:currentNum,
        // states[2]:modeNum, states[3]:maxNum
        int[] states = new int[4];
        inorder(root, states, null);
        int[] modes = new int[states[2]];
        states[1] = states[2] = 0;
        inorder(root, states, modes);
        return modes;
    }
    
    private void handleValue(int val, int[] states, int[] modes) {
        if (states[0] != val) {
            states[0] = val;
            states[1] = 0;
        }
        ++states[1];
        if (states[1] > states[3]) {
            states[3] = states[1];
            states[2] = 1;
        }
        else if (states[1] == states[3]) {
            if (modes != null)
                modes[states[2]] = states[0];
            ++states[2];
        }
    }
    
    private void inorder(TreeNode root, int[] states, int[] modes) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                handleValue(current.val, states, modes);
                current = current.right;
            }
            else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else {
                    pre.right = null;
                    handleValue(current.val, states, modes);
                    current = current.right;
                }
            }
        }
    }
}
