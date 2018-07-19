class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            map.put(words[i], i);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String w = words[i];
            int l = w.length();
            for (int j = 0; j <= l; ++j) {
                if (isPalindrome(w, 0, j - 1)) {
                    String rev = new StringBuilder(w.substring(j)).reverse().toString();
                    Integer p = map.get(rev);
                    if (p != null && p != i) {
                        result.add(Arrays.asList(p, i));
                    }
                }
                
                if (j < l && isPalindrome(w, j, l - 1)) {
                    String rev = new StringBuilder(w.substring(0, j)).reverse().toString();
                    Integer p = map.get(rev);
                    if (p != null && p != i) {
                        result.add(Arrays.asList(i, p));
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i++] != arr[j--]) return false;
        }
        return true;
    }
}

// Trie
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        int n = words.length;
        for (int i = 0; i < n; ++i) add(root, words[i], i);
        for (int i = 0; i < n; ++i) search(result, root, words[i], i);
        return result;
    }
    
    private void search(List<List<Integer>> result, TrieNode root, String word, int index) {
        char[] arr = word.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            if (root.index >= 0 && root.index != index && isPalindrome(word, i, n - 1)) {
                result.add(Arrays.asList(index, root.index));
            }
            root = root.next[arr[i] - 'a'];
            if (root == null) return;
        }
        
        for (int i : root.list) {
            if (i == index) continue;
            result.add(Arrays.asList(index, i));
        }
    }
    
    private void add(TrieNode root, String word, int index) {
        char[] arr = word.toCharArray();
        int n = arr.length;
        for (int i = n - 1; i >= 0; --i) {
            if (root.next[arr[i] - 'a'] == null) {
                root.next[arr[i] - 'a'] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }
            root = root.next[arr[i] - 'a'];
        }
        root.index = index;
        root.list.add(index);
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i++] != arr[j--]) return false;
        }
        return true;
    }
    
    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;
        
        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }
}