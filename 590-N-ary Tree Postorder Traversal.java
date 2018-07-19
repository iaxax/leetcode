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
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            for (Node n : root.children) {
                result.addAll(postorder(n));
            }
            result.add(root.val);
        }
        
        return result;
    }
}