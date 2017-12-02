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
    ListNode* swapPairs(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        
        ListNode *one = new ListNode(0);
        ListNode *first = one;
        one->next = head;
        ListNode *two = head, *three = head->next;
        while (three != nullptr) {
            one->next = three;
            two->next = three->next;
            three->next = two;
            one = two;
            two = two->next;
            if (two == nullptr) break;
            three = two->next;
        }
        
        ListNode *result = first->next;
        delete first;
        return result;
    }
};