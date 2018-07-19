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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) queue.addLast(root);
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                Node node = queue.removeFirst();
                list.add(node.val);
                if (node.children != null) {
                    for (Node c : node.children) {
                        queue.addLast(c);
                    }
                }
            }
            result.add(list);
        }
        return result;
    }
}