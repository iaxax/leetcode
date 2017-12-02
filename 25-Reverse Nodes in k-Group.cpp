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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (k < 2) return head;
        
        ListNode *first = new ListNode(0);
        first->next = head;
        ListNode *cur = first;
        while (cur != nullptr) {
            ListNode *node = cur;
            int i;
            for (i = 0; i < k; ++i) {
                if (cur != nullptr) {
                    cur = cur->next;
                }
                else {
                    break;
                }
            }
            if (i < k || cur == nullptr) break;
            
            ListNode *mid = node->next;
            ListNode *insert = mid->next;
            ListNode *end = cur->next;
            while (insert != end) {
                mid->next = insert->next;
                insert->next = node->next;
                node->next = insert;
                insert = mid->next;
            }
            cur = mid;
        }
        
        ListNode *result = first->next;
        delete first;
        return result;
    }
};