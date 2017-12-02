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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode *head = new ListNode(0);
        ListNode *cur = head;
        int sz = lists.size();
        
        priority_queue<NodeWrapper> *q = new priority_queue<NodeWrapper>;
        for (ListNode * n : lists) {
            if (n != nullptr) q->push(NodeWrapper(n));
        }
        
        while (!q->empty()) {
            const NodeWrapper &nw = q->top();
            cur->next = nw.node;
            cur = cur->next;
            q->pop();
            if (cur->next != nullptr) {
                q->push(NodeWrapper(cur->next));
            }
        }
        
        ListNode *result = head->next;
        delete q;
        delete head;
        return result;
    }
    
private:
    struct NodeWrapper {
        ListNode *node;
        NodeWrapper(ListNode *n) : node(n) {}
        
        bool operator<(const NodeWrapper &n) const {
            return node->val > n.node->val;
        }
    };
};