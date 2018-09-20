/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        collectAll(map, root);
        
        List<TreeNode> result = new ArrayList<>();
        for (List<TreeNode> list : map.values()) {
            if (list.size() <= 1) {
                continue;
            }
            
            int[] uf = init(list);
            for (int i = 0; i < uf.length; ++i) {
                if (uf[i] < -1) {
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }
    
    private int collectAll(HashMap<Integer, List<TreeNode>> map, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = collectAll(map, root.left);
        int rh = collectAll(map, root.right);
        int h = Math.max(lh, rh) + 1;
        List<TreeNode> list = map.getOrDefault(h, new ArrayList<>());
        list.add(root);
        map.put(h, list);
        return h;
    }
    
    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2 == null;
        if (t2 == null) return t1 == null;
        return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
    
    private int[] init(List<TreeNode> list) {
        int n = list.size();
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int r1 = find(parents, i);
                int r2 = find(parents, j);
                if (r1 != r2 && isSame(list.get(r1), list.get(r2))) {
                    union(parents, i, j);
                }
            }
        }
        
        return parents;
    }
    
    private int find(int[] parents, int i) {
        while (parents[i] >= 0) {
            i = parents[i];
        }
        return i;
    }
    
    private void union(int[] parents, int i, int j) {
        int r1 = find(parents, i);
        int r2 = find(parents, j);
        if (r1 == r2) {
            return;
        }
        int temp = parents[r2];
        parents[r2] = r1;
        parents[r1] += temp;
    }
}

// a more elegant solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        findDuplicateSubtrees(result, new HashMap<>(), root);
        return result;
    }
    
    private String findDuplicateSubtrees(List<TreeNode> result, HashMap<String, Integer> map, TreeNode root) {
        if (root == null) {
            return "";
        }
        
        String serialized = root.val + ","
            + findDuplicateSubtrees(result, map, root.left) + ","
            + findDuplicateSubtrees(result, map, root.right);
        int count = map.getOrDefault(serialized, 0);
        if (count == 1) {
            result.add(root);
        }
        map.put(serialized, count + 1);
        return serialized;
    }
}