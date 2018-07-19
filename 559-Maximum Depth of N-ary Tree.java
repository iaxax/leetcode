/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        int depth = 0;
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                Node node = queue.removeFirst();
                for (Node c : node.children) {
                    queue.addLast(c);
                }
            }
            ++depth;
        }
        return depth;
    }
}