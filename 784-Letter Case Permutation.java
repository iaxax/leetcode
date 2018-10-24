class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        letterCasePermutation(result, S, "", 0);
        return result;
    }
    
    public void letterCasePermutation(List<String> result, String S, String prefix, int index) {
        if (index >= S.length()) {
            result.add(prefix);
            return;
        }
        
        char c = S.charAt(index);
        letterCasePermutation(result, S, prefix + c, index + 1);
        if (!Character.isDigit(c)) {
            letterCasePermutation(result, S, prefix + toAnotherCase(c), index + 1);
        }
    }
    
    private char toAnotherCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char)('A' + c - 'a');
        } else {
            return (char)('a' + c - 'A');
        }
    }
}