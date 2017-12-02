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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr || l2 == nullptr) return nullptr;
        
        ListNode *result = new ListNode(0);
        ListNode *head = result;
        int val, carry = 0;
        while (l1 != nullptr && l2 != nullptr) {
            val = l1->val + l2->val + carry;
            carry = val / 10;
            val = val % 10;
            result->next = new ListNode(val);
            result = result->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        
        if (l1 != nullptr) {
            rest(l1, result);
        }
        
        if (l2 != nullptr) {
            rest(l2, result);
        }
        
        if (carry == 1) {
            if (result->next == nullptr) {
                result->next = new ListNode(1);
            }
            else {
                addOne(result->next);
            }
        }
        
        result = head->next;
        delete head;
        return result;
    }
private:
    void rest(ListNode *l, ListNode *result) {
        while (l != nullptr) {
            result->next = new ListNode(l->val);
            result = result->next;
            l = l->next;
        }
    }
    
    void addOne(ListNode *l) {
        int carry = 1;
        ListNode *pre;
        while (l != nullptr) {
            int c = carry;
            carry = (l->val + carry) / 10;
            l->val = (l->val + c) % 10;
            pre = l;
            l = l->next;
        }
        if (carry == 1) pre->next = new ListNode(1);
    }
};