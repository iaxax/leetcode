class Solution {
    public String toLowerCase(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char)(c - 'A' + 'a'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}