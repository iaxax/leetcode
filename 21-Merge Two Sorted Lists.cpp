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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *head = new ListNode(0);
        ListNode *cur = head;
        
        while (l1 != nullptr && l2 != nullptr) {
            if (l1->val < l2->val) {
                cur->next = l1;
                cur = cur->next;
                l1 = l1->next;
            }
            else if (l1->val > l2->val) {
                cur->next = l2;
                cur = cur->next;
                l2 = l2->next;
            }
            else {
                cur->next = l1;
                cur = cur->next;
                l1 = l1->next;
                cur->next = l2;
                cur = cur->next;
                l2 = l2->next;
            }
        }
        
        while (l1 != nullptr) {
            cur->next = l1;
            cur = cur->next;
            l1 = l1->next;
        }
        
        while (l2 != nullptr) {
            cur->next = l2;
            cur = cur->next;
            l2 = l2->next;
        }
        
        ListNode *result = head->next;
        delete head;
        return result;
    }
};