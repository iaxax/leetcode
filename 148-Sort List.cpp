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
    ListNode* sortList(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        
        ListNode *prev = nullptr;
        ListNode *walker = head, *runner = head;
        while (runner != nullptr && runner->next != nullptr) {
            prev = walker;
            walker = walker->next;
            runner = runner->next->next;
        }
        
        prev->next = nullptr;
        ListNode *left = sortList(head);
        ListNode *right = sortList(walker);
        return merge(left, right);
    }

private:
    ListNode* merge(ListNode *l1, ListNode *l2) {
        ListNode head(0);
        ListNode *cur = &head;
        
        while (l1 != nullptr && l2 != nullptr) {
            if (l1->val < l2->val) {
                cur->next = l1;
                l1 = l1->next;
            }
            else {
                cur->next = l2;
                l2 = l2->next;
            }
            cur = cur->next;
        }
        
        if (l1 != nullptr) {
            cur->next = l1;
        }
        
        if (l2 != nullptr) {
            cur->next = l2;
        }
        
        return head.next;
    }
};

// qsort, but it cosumes too much time (I don't know why)
class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (head == nullptr) {
            return nullptr;
        }
        
        ListNode *end = head;
        while (end->next != nullptr) {
            end = end->next;
        }
        
        qsortList(head, end);
        return head;
    }
    
private:
    void qsortList(ListNode *begin, ListNode *end) {
        if (begin == end) {
            return;
        }
        
        ListNode *pre = begin;
        ListNode *p = begin, *cur = begin;
        while (cur != end) {
            if (cur->val < end->val) {
                swap(p->val, cur->val);
                pre = p;
                p = p->next;
            }
            cur = cur->next;
        }
        
        qsortList(begin, pre);
        if (p != end) {
            swap(p->val, end->val);
            qsortList(p->next, end);
        }
    }
};