class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }
        
        boolean[] visited = new boolean[26];
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            --count[c - 'a'];
            if (visited[c - 'a']) continue;
            while (!stack.isEmpty() && count[stack.getLast() - 'a'] > 0 && c < stack.getLast()) {
                visited[stack.getLast() - 'a'] = false;
                stack.removeLast();
            }
            stack.addLast(c);
            visited[c - 'a'] = true;
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}