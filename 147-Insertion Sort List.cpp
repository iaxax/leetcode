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
    ListNode* insertionSortList(ListNode* head) {
        if (head == nullptr) {
            return head;
        }
        
        ListNode fakeHead(0);
        fakeHead.next = head;
        ListNode *pre = head;
        ListNode *cur = head->next;
        
        while (cur != nullptr) {
            if (pre->val <= cur->val) {
                pre = cur;
                cur = cur->next;
                continue;
            }
            
            ListNode *insert = &fakeHead;
            while (insert->next->val < cur->val) {
                insert = insert->next;
            }
            
            ListNode *next = cur->next;
            pre->next = next;
            cur->next = insert->next;
            insert->next = cur;
            cur = next;
        }
        
        return fakeHead.next;
    }
};