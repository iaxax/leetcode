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
    vector<int> postorderTraversal(TreeNode* root) {
        deque<int> traversal;
        stack<TreeNode*> stk;
        TreeNode *cur = root;
        
        while (!stk.empty() || cur != nullptr) {
            if (cur != nullptr) {
                stk.push(cur);
                traversal.push_front(cur->val);
                cur = cur->right;
            }
            else {
                TreeNode *n = stk.top();
                stk.pop();
                cur = n->left;
            }
        }
        
        return vector<int>(traversal.begin(), traversal.end());
    }
};

// recursive solution
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        postorder(result, root);
        return result;
    }
    
private:
    void postorder(vector<int> &result, TreeNode *root) {
        if (root == nullptr) {
            return;
        }
        
        postorder(result, root->left);
        postorder(result, root->right);
        result.push_back(root->val);
    }
};

// morris traversal
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        TreeNode dump(0);
        dump.left = root;
        TreeNode *cur = &dump;
        
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
                    reverseAddNodes(cur->left, predecessor, result);
                    predecessor->right = nullptr;
                    cur = cur->right;
                }
            }
            else {
                cur = cur->right;
            }
        }
        
        return result;
    }
    
private:
    void reverseAddNodes(TreeNode *start, TreeNode *end, vector<int> &result) {
        reverseNodes(start, end);
        TreeNode *n = end;
        while (true) {
            result.push_back(n->val);
            if (n == start) {
                break;
            }
            n = n->right;
        }
        reverseNodes(end, start);
    }
    
    void reverseNodes(TreeNode *start, TreeNode *end) {
        TreeNode *pre = start;
        TreeNode *cur = start->right;
        while (pre != end) {
            TreeNode *next = cur->right;
            cur->right = pre;
            pre = cur;
            cur = next;
        }
    }
};