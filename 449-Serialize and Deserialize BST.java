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
    
    private class NullNode extends TreeNode {
        NullNode(int x) { super(x); }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        StringBuilder builder = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                if (node instanceof NullNode) {
                    builder.append("N,");
                } else {
                    builder.append(node.val + ",");
                    q.offer(node.left == null ? new NullNode(0) : node.left);
                    q.offer(node.right == null ? new NullNode(0) : node.right);
                }
            } else {
                builder.append("N,");
            }
        }
        
        String result = builder.toString();
        return result.substring(0, result.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int size = nodes.length;
        TreeNode root = new TreeNode(0);
        if (nodes[0].equals("N")) {
            return null;
        } else {
            root.val = Integer.parseInt(nodes[0]);
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int index = 1;
        while (index < size) {
            TreeNode node = q.poll();
            String l = nodes[index];
            String r = nodes[index + 1];
            if (!l.equals("N")) {
                TreeNode left = new TreeNode(Integer.parseInt(l));
                node.left = left;
                q.offer(left);
            }
            if (!r.equals("N")) {
                TreeNode right = new TreeNode(Integer.parseInt(r));
                node.right = right;
                q.offer(right);
            }
            index += 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
