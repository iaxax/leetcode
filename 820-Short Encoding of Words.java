class Solution {
    public int minimumLengthEncoding(String[] words) {
        int result = 0;
        TrieNode root = new TrieNode();
        for (String word : words) {
            result += insert(root, word);
        }
        return result;
    }
    
    private int insert(TrieNode root, String word) {
        int num = 0, depth = 1;
        for (int i = word.length() - 1; i >= 0; --i) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }
            if (root.next[j].end) {
                root.next[j].end = false;
                num -= depth + 1;
            }
            root.hasNext = true;
            root = root.next[j];
            depth = depth + 1;
        }
        
        if (root.hasNext) {
            return 0;
        } else {
            root.end = true;
            return num + word.length() + 1;
        }
    }
    
    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean end = false;
        boolean hasNext = false;
    }
}