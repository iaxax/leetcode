class Solution {
public:
	ListNode* rotateRight(ListNode* head, int k) {
		if (head == nullptr) return head;

		ListNode *cur = head;
		ListNode *tail = head;
		int len = 0;
		while (cur != nullptr) {
			++len;
			tail = cur;
			cur = cur->next;
		}
		tail->next = head;

		if (len != 0) {
			k = k % len;
		}

		cur = head;
		for (int i = 0; i < len -1 - k; ++i) {
			cur = cur->next;
		}
		ListNode *result = cur->next;
		cur->next = nullptr;
		return result;
	}
};