class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for (int i = 0; i < n - 1; ++i) {
            sb.append(new StringBuilder(words[i]).reverse().toString()).append(" ");
        }
        sb.append(new StringBuilder(words[n - 1]).reverse().toString());
        return sb.toString();
    }
}
