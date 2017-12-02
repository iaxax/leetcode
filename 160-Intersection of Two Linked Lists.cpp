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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (headA == nullptr || headB == nullptr) {
            return nullptr;
        }
        
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);
        int diff = max(lenA, lenB) - min(lenA, lenB);
        ListNode *shortList = lenA < lenB ? headA : headB;
        ListNode *longList = shortList == headA ? headB : headA;
        
        longList = forward(longList, diff);
        while (shortList != nullptr && longList != nullptr) {
            if (shortList == longList) {
                return shortList;
            }
            shortList = shortList->next;
            longList = longList->next;
        }
        
        return nullptr;
    }
    
private:
    inline int getListLength(ListNode *l) {
        int len = 0;
        ListNode *cur = l;
        while (cur != nullptr) {
            cur = cur->next;
            len += 1;
        }
        return len;
    }
    
    inline ListNode* forward(ListNode *l, int step) {
        ListNode *cur = l;
        for (int i = 0; i < step; ++i) {
            cur = cur->next;
        }
        return cur;
    }
};

// more elegant and faster solution
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (headA == nullptr || headB == nullptr) {
            return nullptr;
        }
        
        ListNode *l1 = headA;
        ListNode *l2 = headB;
        
        while (l1 != l2) {
            l1 = l1 == nullptr ? headB : l1->next;
            l2 = l2 == nullptr ? headA : l2->next;
        }
        
        return l1;
    }
};