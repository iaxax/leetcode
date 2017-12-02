public class Solution {
    
    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word = null;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        TrieNode trie = buildTrie(words);
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(trie, board, result, i, j);
            }
        }
        return result;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            TrieNode current = trie;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (current.child[index] == null) {
                    current.child[index] = new TrieNode();
                }
                current = current.child[index];
            }
            current.word = word;
        }
        return trie;
    }
    
    private void dfs(TrieNode root, char[][] board, List<String> result, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] != '&') {
            int index = board[row][col] - 'a';
            if (root.child[index] == null) {
                return;
            }
            
            root = root.child[index];
            if (root.word != null) {
                result.add(root.word);
                root.word = null;
            }
            
            board[row][col] = '&';
            dfs(root, board, result, row + 1, col);
            dfs(root, board, result, row - 1, col);
            dfs(root, board, result, row, col + 1);
            dfs(root, board, result, row, col - 1);
            board[row][col] = (char)(index + 'a');
        }
    }
}
