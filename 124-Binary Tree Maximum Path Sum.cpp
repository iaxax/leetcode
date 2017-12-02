/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxPathSum(TreeNode* root) {
        int maxSum = INT_MIN;
        pathSum(root, maxSum);
        return maxSum;
    }
    
private:
    int pathSum(TreeNode *root, int &maxSum) {
        if (root == nullptr) return 0;
        int left  = max(pathSum(root->left, maxSum), 0);
        int right = max(pathSum(root->right, maxSum), 0);
        maxSum = max(maxSum, left + right + root->val);
        return root->val + max(left, right);
    }
};