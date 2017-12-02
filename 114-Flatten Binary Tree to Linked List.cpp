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
    void flatten(TreeNode* root) {
        if (root == nullptr) return;
        
        flatten(root->left);
        TreeNode *leftTail = root->left;
        while (leftTail != nullptr && leftTail->right != nullptr) {
            leftTail = leftTail->right;
        }
        
        flatten(root->right);
        if (leftTail != nullptr) {
            leftTail->right = root->right;
            root->right = root->left;
            root->left = nullptr;
        }
    }
};

// slower but shorter solution
class Solution {
public:
    void flatten(TreeNode* root) {
        TreeNode *pre = nullptr;
        flatten(root, pre);
    }
    
private:
    void flatten(TreeNode* root, TreeNode *&pre) {
        if (root == nullptr) return;
        flatten(root->right, pre);
        flatten(root->left, pre);
        root->right = pre;
        root->left = nullptr;
        pre = root;
    }
};