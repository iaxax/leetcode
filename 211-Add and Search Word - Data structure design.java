public class WordDictionary {
    
    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isWord = false;
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            if (current.child[index] == null) {
                current.child[index] = new TrieNode();
            }
            current = current.child[index];
        }
        current.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }
    
    private boolean search(TrieNode root, String word, int from) {
        if (root == null) return false;
        if (from == word.length()) return root.isWord;
        
        if (word.charAt(from) == '.') {
            for (int i = 0; i < 26; ++i) {
                if (root.child[i] != null && search(root.child[i], word, from + 1)) return true;
            }
            return false;
        }
        else {
            return search(root.child[word.charAt(from) - 'a'], word, from + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
