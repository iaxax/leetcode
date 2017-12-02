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
    ListNode *detectCycle(ListNode *head) {
        ListNode *walker = head;
        ListNode *runner = head;
        while (runner != nullptr && runner->next != nullptr) {
            walker = walker->next;
            runner = runner->next->next;
            if (walker == runner) {
                ListNode *entry = head;
                while (walker != entry) {
                    walker = walker->next;
                    entry = entry->next;
                }
                return entry;
            }
        }
        return nullptr;
    }
};