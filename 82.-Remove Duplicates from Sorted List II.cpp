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
	ListNode* deleteDuplicates(ListNode* head) {
		if (head == nullptr || head->next == nullptr) return head;
		
		ListNode *first = new ListNode(0);
		first->next = head;
		ListNode *pre = first;
		ListNode *cur = head;
		
		while (cur != nullptr) {
            while (cur->next != nullptr && cur->val == cur->next->val) {
                cur = cur->next;
            }
            if (cur == pre->next) {
                pre = pre->next;
            }
            else {
                pre->next = cur->next;
            }
            cur = cur->next;
		}
		
		ListNode *result = first->next;
		delete first;
		return result;
	}
};