public class Trie {
    
    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (current.child[c - 'a'] == null) {
                current.child[c - 'a'] = new TrieNode();
            }
            current = current.child[c - 'a'];
        }
        current.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (current.child[c - 'a'] == null) return false;
            current = current.child[c - 'a'];
        }
        return current != null && current.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (current.child[c - 'a'] == null) return false;
            current = current.child[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
