/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null) return quadTree2;
        if (quadTree2 == null) return quadTree1;
        
        if (quadTree1.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        if (quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        }
        
        Node tl = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node tr = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bl = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node br = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        
        boolean notNull = tl != null && tr != null && bl != null && br != null;
        if (notNull) {
            boolean isLeaf = tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf;
            if (isLeaf) {
                boolean isSame = tl.val == tr.val && tr.val == bl.val && bl.val == br.val;
                return isSame ? new Node(tl.val, true, null, null, null, null)
                    : new Node(false, false, tl, tr, bl, br);
            }
            return new Node(false, false, tl, tr, bl, br);
        } else {
            return new Node(false, false, tl, tr, bl, br);
        }
    }
}