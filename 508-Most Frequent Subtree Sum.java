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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> count = new HashMap<>();
        sum(root, count);
        
        int maxFrequent = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getValue();
            if (num > maxFrequent) {
                maxFrequent = num;
                list.clear();
                list.add(entry.getKey());
            } else if (num == maxFrequent) {
                list.add(entry.getKey());
            }
        }
        
        int n = list.size();
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private int sum(TreeNode root, HashMap<Integer, Integer> count) {
        if (root == null) return 0;
        
        TreeNode left = root.left;
        int leftSum = sum(left, count);
        TreeNode right = root.right;
        int rightSum = sum(right, count);
        
        int sum = leftSum + rightSum + root.val;
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        return sum;
    }
    
}
