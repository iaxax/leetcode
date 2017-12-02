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
	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
		return buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1);
	}

private:
	TreeNode* buildTree(const vector<int> &preorder, int preBegin, int preEnd,
		const vector<int> &inorder, int inBegin, int inEnd)
	{
		if (preEnd - preBegin != inEnd - inBegin || preEnd < preBegin) return nullptr;

		int rootVal = preorder[preBegin];
		int rootIdx = inBegin;
		while (inorder[rootIdx] != rootVal) {
			rootIdx += 1;
		}

		TreeNode *root = new TreeNode(rootVal);
		root->left = buildTree(preorder, preBegin + 1, preBegin + rootIdx - inBegin, inorder, inBegin, rootIdx - 1);
		root->right = buildTree(preorder, preBegin + 1 + rootIdx - inBegin, preEnd, inorder, rootIdx + 1, inEnd);

		return root;
	}
};