
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
	void recoverTree(TreeNode* root) {
		TreeNode *cur = root, *pre = nullptr;
		TreeNode *one = nullptr, *two = nullptr;

		while (cur != nullptr) {
			if (cur->left != nullptr) {
				TreeNode *precessor = cur->left;
				while (precessor->right != nullptr && precessor->right != cur) {
					precessor = precessor->right;
				}
				if (precessor->right == nullptr) {
					precessor->right = cur;
					cur = cur->left;
				}
				else {
					if (pre != nullptr && pre->val >= cur->val) {
    					if (two == nullptr) {
    					    one = pre; two = cur;
    					}
    					else {
    					    two = cur;
    					}
					}

				    precessor->right = nullptr;
				    pre = cur;
					cur = cur->right;
				}
			}
			else {
				if (pre != nullptr && pre->val >= cur->val) {
					if (pre != nullptr && pre->val >= cur->val) {
    					if (two == nullptr) {
    					    one = pre; two = cur;
    					}
    					else {
    					    two = cur;
    					}
					}
				}

                pre = cur;
				cur = cur->right;
			}
		}
		
		if (one != nullptr && two != nullptr)
		    swap(one->val, two->val);
	}
};