/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        return dfs(head)[0];
    }
    
    private Node[] dfs(Node head) {
        if (head == null) {
            return new Node[] {null, null};
        }
        
        Node current = head;
        while (current.next != null) {
            Node next = current.next;
            if (current.child != null) {
                Node[] nodes = dfs(current.child);
                current.next = nodes[0];
                nodes[0].prev = current;
                nodes[1].next = next;
                next.prev = nodes[1];
                current.child = null;
            }
            current = next;
        }
        
        if (current.child != null) {
            Node[] nodes = dfs(current.child);
            current.next = nodes[0];
            nodes[0].prev = current;
            current.child = null;
            return new Node[] {head, nodes[1]};
        }
        return new Node[] {head, current};
    }
}