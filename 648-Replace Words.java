class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = buildTrie(dict);
        StringBuilder builder = new StringBuilder(sentence.length());
        String[] words = sentence.split(" ");
        builder.append(transfer(trie, words[0]));
        
        int len = words.length;
        for (int i = 1; i < len; ++i) {
            builder.append(' ').append(transfer(trie, words[i]));
        }
        return builder.toString();
    }
    
    private Trie buildTrie(List<String> dict) {
        Trie root = new Trie();
        for (String word : dict) {
            Trie current = root;
            int len = word.length();
            for (int i = 0; i < len - 1; ++i) {
                if (current.next[word.charAt(i) - 'a'] == null) {
                    current.next[word.charAt(i) - 'a'] = new Trie();
                }
                current = current.next[word.charAt(i) - 'a'];
            }
            if (current.next[word.charAt(len - 1) - 'a'] == null) {
                current.next[word.charAt(len - 1) - 'a'] = new Trie();
            }
            current.next[word.charAt(len - 1) - 'a'].isWord = true;
        }
        return root;
    }
    
    private String transfer(Trie trie, String word) {
        Trie current = trie;
        int len = word.length(), i = 0;
        while (i < len) {
            char c = word.charAt(i);
            if (current.next[c - 'a'] == null) return word;
            if (current.next[c - 'a'].isWord) return word.substring(0, i + 1);
            current = current.next[c - 'a'];
            ++i;
        }
        return word;
    }
    
    private class Trie {
        boolean isWord = false;
        Trie[] next = new Trie[26];
    }
}
