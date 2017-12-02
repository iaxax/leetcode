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
    ListNode* partition(ListNode* head, int x) {
        ListNode lessHead(0), greaterHead(0);
        ListNode *lessNode = &lessHead, *greaterNode = &greaterHead;
        while (head != nullptr) {
            if (head->val < x) {
                lessNode = lessNode->next = head;
            }
            else {
                greaterNode = greaterNode->next = head;
            }
            head = head->next;
        }
        greaterNode->next = nullptr;
        lessNode->next = greaterHead.next;
        return lessHead.next;
    }
};