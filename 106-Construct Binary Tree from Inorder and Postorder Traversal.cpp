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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        return buildTree(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1);
    }
    
private:
    TreeNode* buildTree(const vector<int> &inorder, int inBegin, int inEnd,
        const vector<int> &postorder, int postBegin, int postEnd)
    {
        if (inEnd - inBegin != postEnd - postBegin || inBegin > inEnd) return nullptr;
        
        int rootVal = postorder[postEnd];
        int rootIdx = inBegin;
        while (inorder[rootIdx] != rootVal) {
            rootIdx += 1;
        }
        
        TreeNode *root = new TreeNode(rootVal);
        root->left = buildTree(inorder, inBegin, rootIdx - 1, postorder, postBegin, postBegin + rootIdx - 1 - inBegin);
        root->right = buildTree(inorder, rootIdx + 1, inEnd, postorder, postBegin + rootIdx - inBegin, postEnd - 1);
        return root;
    }
};