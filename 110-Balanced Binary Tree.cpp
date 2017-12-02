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
    bool isBalanced(TreeNode* root) {
        unordered_map<TreeNode*, int> depth;
        getDepth(depth, root);
        return isBalanced(depth, root);
    }
private:
    bool isBalanced(unordered_map<TreeNode*, int> &depth, TreeNode* root) {
        if (root == nullptr) return true;
        return abs(depth[root->left] - depth[root->right]) <= 1
            && isBalanced(root->left) && isBalanced(root->right);
    }
    
    int getDepth(unordered_map<TreeNode*, int> &depth, TreeNode* root) {
        if (root == nullptr) return 0;
        
		if (depth.find(root) != depth.end()) return depth[root];
		
        int leftDepth = getDepth(depth, root->left);
        int rightDepth = getDepth(depth, root->right);
        return depth[root] = (max(leftDepth, rightDepth) + 1);
    }
};

// faster and shorter solution
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        return solve(root).first;
    }
private:

    pair<bool, int> solve(TreeNode *root) {
        if (root == nullptr) return {true, 0};
        
        pair<bool, int> left = solve(root->left);
        if (!left.first) return left;
        
        pair<bool, int> right = solve(root->right);
        if (!right.first) return right;
        
        return {abs(left.second - right.second) <= 1, max(left.second, right.second) + 1};
    }
};