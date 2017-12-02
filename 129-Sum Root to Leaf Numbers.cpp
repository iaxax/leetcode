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
    int sumNumbers(TreeNode* root) {
        return sumNumbers(root, 0);
    }
    
private:
    int sumNumbers(TreeNode *root, int sum) {
        if (root == nullptr) return 0;
        
        int newSum = sum * 10 + root->val;
        if (root->left == nullptr && root->right == nullptr) {
            return newSum;
        }
        else {
            return sumNumbers(root->left, newSum) + sumNumbers(root->right, newSum);
        }
    }
};