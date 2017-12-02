/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode* sortedListToBST(ListNode* head) {
        return sortedListToBST(head, getListLength(head));
    }
    
private:
    int getListLength(ListNode* head) {
        int len = 0;
        while (head != nullptr) {
            head = head->next;
            len += 1;
        }
        return len;
    }
    
    ListNode* advance(ListNode* head, int step) {
        for (int i = 0; i < step; ++i) {
            head = head->next;
        }
        return head;
    }
    
    TreeNode* sortedListToBST(ListNode* head, int len) {
        if (len <= 0) return nullptr;
        
        int midIdx = len / 2;
        ListNode* mid = advance(head, midIdx);
        int rootVal = mid->val;
        
        TreeNode* root = new TreeNode(rootVal);
        root->left = sortedListToBST(head, midIdx);
        root->right = sortedListToBST(advance(head, midIdx + 1), len - midIdx - 1);
        return root;
    }
};

// slower but more concise solution
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        return sortedListToBST(head, nullptr);
    }
    
private:
    TreeNode* sortedListToBST(ListNode* head, ListNode* tail) {
        if (head == tail) return nullptr;
        
        ListNode *slow = head, *fast = head;
        while (fast != tail && fast->next != tail) {
            slow = slow->next;
            fast = fast->next->next;
        }
        
        TreeNode *root = new TreeNode(slow->val);
        root->left = sortedListToBST(head, slow);
        root->right = sortedListToBST(slow->next, tail);
        return root;
    }
};