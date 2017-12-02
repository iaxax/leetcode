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
    vector<TreeNode*> generateTrees(int n) {
        vector<TreeNode*> result;
        generateTrees(result, 1, n);
        return result;
    }
    
private:
    void generateTrees(vector<TreeNode*> &trees, int begin, int end) {
        for (int i = begin; i <= end; ++i) {
            vector<TreeNode*> ltree, rtree;
            generateTrees(ltree, begin, i - 1);
            generateTrees(rtree, i + 1, end);
            
            if (ltree.size() == 0) ltree.push_back(nullptr);
            if (rtree.size() == 0) rtree.push_back(nullptr);
                        
            for (TreeNode *left : ltree) {
                for (TreeNode *right : rtree) {
                    TreeNode *root = new TreeNode(i);
                    root->left = left;
                    root->right = right;
                    trees.push_back(root);
                }
            }
        }
    }
};

// DP Solution
class Solution {
public:
    vector<TreeNode*> generateTrees(int n) {
        if (n <= 0) return {};
        
        vector<vector<TreeNode*>> dp(n + 1, vector<TreeNode*>());
        dp[0].push_back(nullptr);
        for (int len = 1; len <= n; ++len) {
            for (int i = 0; i < len; ++i) {
                for (TreeNode *left : dp[i]) {
                    for (TreeNode *right : dp[len - 1 - i]) {
                        TreeNode *node = new TreeNode(i + 1);
                        node->left = left;
                        node->right = clone(right, i + 1);
                        dp[len].push_back(node);
                    }
                }
            }
        }
        return dp[n];
    }
    
private:
    TreeNode* clone(TreeNode* root, int offset) {
        if (root == nullptr) return nullptr;
        
        TreeNode *node = new TreeNode(root->val + offset);
        node->left = clone(root->left, offset);
        node->right = clone(root->right, offset);
        return node;
    }
};