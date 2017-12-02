/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        unordered_map<RandomListNode*, RandomListNode*> mp;
        RandomListNode *result = copyListWithoutRandom(head, mp);
        
        RandomListNode *cur = head;
        while (cur != nullptr) {
            if (cur->random != nullptr) {
                mp[cur]->random = mp[cur->random];
            }
            cur = cur->next;
        }
        
        return result;
    }
    
private:
    RandomListNode* copyListWithoutRandom(RandomListNode *head, unordered_map<RandomListNode*, RandomListNode*> &mp) {
        if (head == nullptr) {
            return nullptr;
        }
        
        RandomListNode *node = new RandomListNode(head->label);
        mp.insert({head, node});
        node->next = copyListWithoutRandom(head->next, mp);
        return node;
    }
    
};