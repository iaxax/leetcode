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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if (head == nullptr) return head;
        
        ListNode node(0);
        node.next = head;
        ListNode *first = &node;
        
        ListNode *pre = first;
        for (int i = 0; i < m - 1; ++i) {
            pre = pre->next;
        }
        
        ListNode *start = pre->next;
        ListNode *then = start->next;
        for (int i = 0; i < n - m; ++i) {
            start->next = then->next;
            then->next = pre->next;
            pre->next = then;
            then = start->next;
        }
        
        return first->next;
    }
};