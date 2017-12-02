class Solution {
    
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        char[] arr = word.toCharArray();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') ++count;
        }
        return count == 0 || count == n || (count == 1 && arr[0] >= 'A' && arr[0] <= 'Z');
    }
}
