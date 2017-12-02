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
    bool isValidBST(TreeNode* root) {
        TreeNode *pre = nullptr;
        return isValidBST(root, pre);
    }
    
private:
    bool isValidBST(TreeNode *node, TreeNode *&pre) {
        if (node == nullptr) return true;
        if (!isValidBST(node->left, pre)) return false;
        if (pre != nullptr && pre->val >= node->val) return false;
        pre = node;
        return isValidBST(node->right, pre);
    }
    
};