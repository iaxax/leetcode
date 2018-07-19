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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        result.add(root.val);
        for (Node n : root.children) {
            result.addAll(preorder(n));
        }
        return result;
    }
}