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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        inorderTraversal(result, root);
        return result;
    }

private:
    void inorderTraversal(vector<int> &result, TreeNode *root) {
        if (root == nullptr) return;
        
        inorderTraversal(result, root->left);
        result.push_back(root->val);
        inorderTraversal(result, root->right);
    }
};

// Iterative method without recursion
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        if (root == nullptr) return {};
        
        stack<TreeNode*> stk;
        TreeNode *cur = root;
        vector<int> result;
        
        while (cur != nullptr || !stk.empty()) {
            if (cur != nullptr) {
                stk.push(cur);
                cur = cur->left;
            }
            else {
                TreeNode *node = stk.top();
                stk.pop();
                result.push_back(node->val);
                cur = node->right;
            }
        }
        
        return result;
    }
};

// Morris traversal
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        TreeNode *cur = root;
        vector<int> result;
        
        while (cur != nullptr) {
            if (cur->left != nullptr) {
                TreeNode *predecessor = cur->left;
                while (predecessor->right != nullptr && predecessor->right != cur) {
                    predecessor = predecessor->right;
                }
                if (predecessor->right == nullptr) {
                    predecessor->right = cur;
                    cur = cur->left;
                }
                else {
                    predecessor->right = nullptr;
                    result.push_back(cur->val);
                    cur = cur->right;
                }
            }
            else {
                result.push_back(cur->val);
                cur = cur->right;
            }
        }
        
        return result;
    }
};