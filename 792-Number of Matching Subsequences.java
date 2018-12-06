class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int num = 0;
        for (String word:words){
            if (isSubsequence(S, word)) {
                num += 1;
            }
        }
        return num;
    }
    
    private boolean isSubsequence(String S, String word){
        int index = -1;
        for (char ch : word.toCharArray()){
            index = S.indexOf(ch, index + 1);
            if(index == -1) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        TrieNode root = buildTrie(words);
        return numMatchingSubseq(S, 0, root);
    }
    
    private int numMatchingSubseq(String S, int index, TrieNode root) {
        if (root == null || index >= S.length()) {
            return 0;
        }
        
        int num = 0;
        for (Map.Entry<Character, TrieNode> entry : root.next.entrySet()) {
            TrieNode next = entry.getValue();
            int pos = S.indexOf(entry.getKey(), index);
            if (pos >= 0) {
                num += next.count;
                num += numMatchingSubseq(S, pos + 1, next);
            }
        }
        return num;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode current = root;
            for (char c : w.toCharArray()) {
                TrieNode next = current.next.get(c);
                if (next == null) {
                    next = new TrieNode();
                    current.next.put(c, next);
                }
                current = next;
            }
            current.count += 1;
        }
        return root;
    }
    
    private static class TrieNode {
        int count = 0;
        Map<Character, TrieNode> next = new HashMap<>();
    }
}

import java.text.StringCharacterIterator;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        List<StringCharacterIterator>[] waiting = new List[128];
        for (int i = 0; i <= 'z'; ++i) {
            waiting[i] = new ArrayList<>();
        }
        
        for (String word : words) {
            waiting[word.charAt(0)].add(new StringCharacterIterator(word));
        }
        
        for (char c : S.toCharArray()) {
            List<StringCharacterIterator> advance = waiting[c];
            waiting[c] = new ArrayList<>();
            for (StringCharacterIterator it : advance) {
                waiting[it.next() % it.DONE].add(it);
            }
        }
        return waiting[0].size();
    }
}
