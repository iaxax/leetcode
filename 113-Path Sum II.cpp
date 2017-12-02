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
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        if (root == nullptr) return {};
        vector<vector<int>> result;
        vector<int> temp = {root->val};
        pathSum(root, sum - root->val, result, temp);
        return result;
    }
    
private:
    void pathSum(TreeNode* root, int sum, vector<vector<int>> &result, vector<int> &temp) {
        if (root ->left == nullptr && root->right == nullptr) {
            if (sum == 0)
                result.push_back(temp);
            return;
        }
        
        if (root->left != nullptr) {
            temp.push_back(root->left->val);
            pathSum(root->left, sum - root->left->val, result, temp);
            temp.pop_back();
        }
        
        if (root->right != nullptr) {
            temp.push_back(root->right->val);
            pathSum(root->right, sum - root->right->val, result, temp);
            temp.pop_back();
        }
    }
};