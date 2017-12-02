/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        while (root != nullptr) {
            TreeLinkNode* tempChild = new TreeLinkNode(0);
            TreeLinkNode* curChild = tempChild;
            while (root != nullptr) {
                if (root->left != nullptr) curChild = curChild->next = root->left;
                if (root->right != nullptr) curChild = curChild->next = root->right;
                root = root->next;
            }
            root = tempChild->next;
            delete tempChild;
        }
    }
};