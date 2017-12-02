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
    void reorderList(ListNode* head) {
        ListNode *walker = head;
        ListNode *runner = head;
        while (runner != nullptr && runner->next != nullptr) {
            walker = walker->next;
            runner = runner->next->next;
        }
        
        walker = reverse(walker);
        merge(head, walker);
    }
    
private:
    ListNode* reverse(ListNode *start) {
        if (start == nullptr || start->next == nullptr) {
            return start;
        }
        
        ListNode *pre = start;
        ListNode *cur = start->next;
        start->next = nullptr;
        while (cur != nullptr) {
            ListNode *next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }
    
    void merge(ListNode *l1, ListNode *l2) {
        ListNode *n1 = l1, *n2 = l2;
        while (n2 != nullptr && n2->next != nullptr) {
            ListNode *next1 = n1->next;
            n1->next = n2;
            ListNode *next2 = n2->next;
            n2->next = next1;
            n1 = next1;
            n2 = next2;
        }
    }
};