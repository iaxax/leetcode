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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        vector<ListNode*> v;
        ListNode* cur = head;
        ListNode* npast = head;
        for (int i = 0; i < n; ++i) {
            npast = npast->next;
        }
        
        ListNode *pre = head;
        while (npast != nullptr) {
            npast = npast->next;
            pre = cur;
            cur = cur->next;
        }
        
        if (cur == head) {
            ListNode *result = head->next;
            delete head;
            return result;
        }
        
        ListNode *rm = cur;
        pre->next = cur->next;
        delete rm;
        return head;
    }
};