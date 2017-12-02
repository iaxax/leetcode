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
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr) return true;
        
        ReverseTreeNode *rnode = (ReverseTreeNode*) root;
        return isSame(root, rnode);
    }
    
private:
    struct ReverseTreeNode {
        int val;
        ReverseTreeNode *right;
        ReverseTreeNode *left;
        ReverseTreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    };
    
    bool isSame(TreeNode *node, ReverseTreeNode *rnode) {
        if (node == nullptr && rnode == nullptr) return true;
        if (node == nullptr || rnode == nullptr) return false;
        return node->val == rnode->val && isSame(node->left, rnode->left) && isSame(node->right, rnode->right);
    }
};

// recursive solution
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr) return true;
        return isSymmetric(root->left, root->right);
    }

private:
    bool isSymmetric(TreeNode *l, TreeNode *r) {
        if (l == nullptr && r == nullptr) return true;
        if (l == nullptr || r == nullptr) return false;
        return l->val == r->val && isSymmetric(l->left, r->right) && isSymmetric(l->right, r->left);
    }
};

// iterative solution
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == nullptr || root->left == nullptr && root->right == nullptr) return true;
        if (root->left == nullptr || root->right == nullptr) return false;
        
        TreeNode *l = root->left, *r = root->right;
        stack<TreeNode*> lstk, rstk;
        
        while ((l != nullptr || !lstk.empty()) && (r != nullptr || !rstk.empty())) {
            if (l == nullptr && r == nullptr) {
                l = lstk.top();
                r = rstk.top();
                lstk.pop();
                rstk.pop();
            }
            
            if (l == nullptr || r == nullptr || l->val != r->val) {
                return false;
            }
            
            if (l->right != nullptr || r->left != nullptr) {
                lstk.push(l->right);
                rstk.push(r->left);
            }
            
            l = l->left;
            r = r->right;
        }
        
        return true;
    }
};