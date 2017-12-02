class Solution {
    public boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int aCount = 0, lCount = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 'A') ++aCount;
            if (arr[i] == 'L') ++lCount;
            else lCount = 0;
            if (aCount > 1 || lCount > 2) return false;
        }
        return true;
    }
}
