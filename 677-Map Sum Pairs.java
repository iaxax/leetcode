class MapSum {
    
    private TrieNode trie;

    /** Initialize your data structure here. */
    public MapSum() {
        trie = new TrieNode();
    }
    
    public void insert(String key, int val) {
        insert(trie, key, val);
    }
    
    public int sum(String prefix) {
        TrieNode root = trie;
        for (char c : prefix.toCharArray()) {
            if (!root.next.containsKey(c - 'a')) {
                return 0;
            }
            root = root.next.get(c - 'a');
        }
        return sum(root);
    }
    
    private static class TrieNode {
        boolean isWord = false;
        int value = 0;
        HashMap<Integer, TrieNode> next = new HashMap<>();
    }
    
    private void insert(TrieNode root, String key, int val) {
        for (char c : key.toCharArray()) {
            if (!root.next.containsKey(c - 'a')) {
                root.next.put(c - 'a', new TrieNode());
            }
            root = root.next.get(c - 'a');
        }
        root.isWord = true;
        root.value = val;
    }
    
    private int sum(TrieNode root) {
        if (root == null) {
            return 0;
        }
        
        int result = root.value;
        for (TrieNode node : root.next.values()) {
            result += sum(node);
        }
        return result;
    }
}

// a more elegant solution
class MapSum {
    
    private TrieNode trie;
    
    private HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        trie = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        TrieNode root = this.trie;
        int v = val - map.getOrDefault(key, 0);
        map.put(key, val);
        
        for (char c : key.toCharArray()) {
            HashMap<Integer, TrieNode> next = root.next;
            TrieNode node = next.get(c - 'a');
            if (node == null) {
                node = new TrieNode();
                next.put(c - 'a', node);
            }
            node.sum += v;
            root = node;
        }
        
        root.isWord = true;
    }
    
    public int sum(String prefix) {
        TrieNode root = trie;
        for (char c : prefix.toCharArray()) {
            HashMap<Integer, TrieNode> next = root.next;
            TrieNode node = next.get(c - 'a');
            if (node == null) {
                return 0;
            }
            root = node;
        }
        return root.sum;
    }
    
    private static class TrieNode {
        boolean isWord = false;
        int sum = 0;
        HashMap<Integer, TrieNode> next = new HashMap<>();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */