/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        unordered_map<int, UndirectedGraphNode*> mp;
        return cloneGraph(node, mp);
    }

private:  
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node, unordered_map<int, UndirectedGraphNode*> &mp) {
        if (node == nullptr) return nullptr;
        
        if (mp.find(node->label) != mp.end()) {
            return mp[node->label];
        }
        
        UndirectedGraphNode *n = new UndirectedGraphNode(node->label);
        mp.insert({n->label, n});
        for (UndirectedGraphNode *neighbor : node->neighbors) {
            n->neighbors.push_back(cloneGraph(neighbor, mp));
        }
        return n;
    }
};