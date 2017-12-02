class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        return verify(nodes, 0) == nodes.length;
    }
    
    private int verify(String[] nodes, int index) {
        if (index == nodes.length || index == -1) return -1;
        if (nodes[index].equals("#")) return index + 1;
        return verify(nodes, verify(nodes, index + 1));
    }
}

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
