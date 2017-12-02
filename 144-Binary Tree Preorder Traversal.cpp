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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> stk;
        TreeNode *cur = root;
        
        while (!stk.empty() || cur != nullptr) {
            if (cur != nullptr) {
                stk.push(cur);
                result.push_back(cur->val);
                cur = cur->left;
            }
            else {
                TreeNode *n = stk.top();
                stk.pop();
                cur = n->right;
            }
        }
        
        return result;
    }
};

// recursive solution
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        preorder(result, root);
        return result;
    }
    
private:
    void preorder(vector<int> &result, TreeNode *root) {
        if (root == nullptr) {
            return;
        }
        
        result.push_back(root->val);
        preorder(result, root->left);
        preorder(result, root->right);
    }
};

// morris traversal
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        TreeNode *cur = root;
        
        while (cur != nullptr) {
            if (cur->left != nullptr) {
                TreeNode *predecessor = cur->left;
                while (predecessor->right != nullptr && predecessor->right != cur) {
                    predecessor = predecessor->right;
                }
                
                if (predecessor->right == nullptr) {
                    result.push_back(cur->val);
                    predecessor->right = cur;
                    cur = cur->left;
                }
                else {
                    predecessor->right = nullptr;
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
