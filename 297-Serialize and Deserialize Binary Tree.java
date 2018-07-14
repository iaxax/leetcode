/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, 0);
    }
    
    private String serialize(TreeNode root, int level) {
        if (root == null) return "()";
        
        StringBuilder builder = new StringBuilder();
        builder.append('(').append(root.val);
        builder.append('#').append(level).append('#');
        builder.append(serialize(root.left, level + 1));
        builder.append('#').append(level).append('#');
        builder.append(serialize(root.right, level + 1));
        builder.append(')');
        
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data, 0);
    }
    
    private TreeNode deserialize(String data, int level) {
        data = data.substring(1, data.length() - 1);
        String[] nodes = data.split("#" + level + "#");
        if (nodes.length == 1) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        root.left = deserialize(nodes[1], level + 1);
        root.right = deserialize(nodes[2], level + 1);
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "()";
        
        StringBuilder builder = new StringBuilder();
        builder.append('(').append(root.val);
        builder.append(',');
        builder.append(serialize(root.left));
        builder.append(',');
        builder.append(serialize(root.right));
        builder.append(')');
        
        return builder.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = {0};
        return deserialize(data, index);
    }
        
    private TreeNode deserialize(String data, int[] index) {
        int i = index[0];
        if (data.charAt(i + 1) == ')') {
            index[0] = i + 2;
            return null;
        }
        
        i = i + 1;
        int val = 0, len = data.length();
        boolean positive = true;
        if (data.charAt(i) == '-') {
            positive = false;
            i = i + 1;
        }
        while (i < len && data.charAt(i) != ',') {
            val = val * 10 + data.charAt(i++) - '0';
        }
        val = positive ? val : -val;
        
        TreeNode root = new TreeNode(val);
        index[0] = i + 1;
        root.left = deserialize(data, index);
        index[0] = index[0] + 1;
        root.right = deserialize(data, index);
        index[0] = index[0] + 1;
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
