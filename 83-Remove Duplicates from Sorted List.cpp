/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *cur = head;
        while (cur != nullptr && cur->next != nullptr) {
            ListNode *n = cur->next;
            if (cur->val == n->val) {
                cur->next = n->next;
            }
            else {
                cur = cur->next;
            }
        }
        
        return head;
    }
};