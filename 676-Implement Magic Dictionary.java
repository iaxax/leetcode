class MagicDictionary {
    
    private TrieNode trie;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        trie = buildTrie(dict);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return search(trie, word);
    }
    
    private static class TrieNode {
        boolean isWord = false;
        TrieNode[] next = new TrieNode[26];
    }
    
    private boolean search(TrieNode root, String word) {
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (root.next[c - 'a'] != null) {
                for (TrieNode node : root.next) {
                    if (node != null && node != root.next[c - 'a']) {
                        if (contains(node, word.substring(i + 1))) {
                            return true;
                        }
                    }
                }
                root = root.next[c - 'a'];
            } else {
                for (TrieNode node : root.next) {
                    if (node != null) {
                        if (contains(node, word.substring(i + 1))) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        
        return false;
    }
    
    private boolean contains(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.next[c - 'a'] != null) {
                root = root.next[c - 'a'];
            } else {
                return false;
            }
        }
        return root.isWord;
    }
    
    private TrieNode buildTrie(String[] dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            insert(root, word);
        }
        return root;
    }
    
    private void insert(TrieNode trie, String word) {
        for (char c : word.toCharArray()) {
            if (trie.next[c - 'a'] == null) {
                trie.next[c - 'a'] = new TrieNode();
            }
            trie = trie.next[c - 'a'];
        }
        trie.isWord = true;
    }
}

class MagicDictionary {
    
    private String[] dict;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        this.dict = dict;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String w : dict) {
            if (oneDiff(w, word)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean oneDiff(String w1, String w2) {
        int n1 = w1.length(), n2 = w2.length();
        if (n1 != n2) {
            return false;
        }
        
        int diff = 0;
        for (int i = 0; i < n1; ++i) {
            if (diff > 1) return false;
            diff += w1.charAt(i) == w2.charAt(i) ? 0 : 1;
        }
        return diff == 1;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */