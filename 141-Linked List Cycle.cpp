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
    bool hasCycle(ListNode *head) {
        ListNode *walker = head;
        ListNode *runner = head;
        
        while (runner != nullptr) {
            walker = walker->next;
            
            runner = runner->next;
            if (runner == nullptr) {
                return false;
            }
            runner = runner->next;
            
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
};

// Another solution, but it will mofify the origin link list
class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode node(0);
        ListNode *cur = head;
        
        while (cur != nullptr) {
            if (cur->next == &node) {
                return true;
            }
            ListNode *next = cur->next;
            cur->next = &node;
            cur = next;
        }
        return false;
    }
};