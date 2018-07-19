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
    public Node construct(int[][] grid) {
        if (grid.length == 0) return null;
        return construct(grid, 0, 0, grid.length);
    }
    
    private Node construct(int[][] grid, int x, int y, int l) {
        if (l == 1) {
            return new Node(grid[x][y] == 1, true, null, null, null, null);
        }
        
        int n = l >> 1;
        Node topLeft = construct(grid, x, y, n);
        Node topRight = construct(grid, x, y + n, n);
        Node bottomLeft = construct(grid, x + n, y, n);
        Node bottomRight = construct(grid, x + n, y + n, n);
        boolean allLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
        boolean oneRegion = topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val;
        if (allLeaf && oneRegion) {
            return new Node(topLeft.val, true, null, null, null, null);
        } else {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}