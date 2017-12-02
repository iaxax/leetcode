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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> result;
        queue<TreeNode*> q;
        if (root != nullptr) q.push(root);
        
        while (!q.empty()) {
            vector<int> v;
            int num = q.size();
            for (int i = 0; i < num; ++i) {
                TreeNode *n = q.front();
                q.pop();
                
                if (n->left != nullptr) q.push(n->left);
                if (n->right != nullptr) q.push(n->right);
                
                v.push_back(n->val);
            }
            
            result.insert(result.begin(), v);
        }
        
        return result;
    }
};