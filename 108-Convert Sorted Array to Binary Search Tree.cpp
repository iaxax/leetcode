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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return sortedArrayToBST(nums, 0, nums.size());
    }
    
private:
    TreeNode* sortedArrayToBST(const vector<int>& nums, int begin, int end) {
        if (begin >= end) return nullptr;
        
        int mid = (begin + end) / 2;
        TreeNode *root = new TreeNode(nums[mid]);
        root->left = sortedArrayToBST(nums, begin, mid);
        root->right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
};