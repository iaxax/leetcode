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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> result;
        queue<TreeNode*> q;
        bool toRight = true;
        if (root != nullptr) q.push(root);
        
        while (!q.empty()) {
            vector<int> v;
            int num = q.size();
            for (int i = 0; i < num; ++i) {
                TreeNode *node = q.front();
                q.pop();
                
                if (node->left != nullptr) q.push(node->left);
                if (node->right != nullptr) q.push(node->right);
                
                if (toRight) {
                    v.push_back(node->val);
                }
                else {
                    v.insert(v.begin(), node->val);
                }
            }
            
            toRight = !toRight;
            result.push_back(v);
        }
        
        return result;
    }
};