class Solution {
    public boolean canTransform(String start, String end) {
        int n1 = start.length(), n2 = end.length();
        if (n1 != n2) return false;
        
        char[] arr1 = start.toCharArray();
        char[] arr2 = end.toCharArray();
        int i = 0;
        for (char c : arr2) {
            if (c == arr1[i]) {
                i = i + 1;
            } else if (c == 'L') {
                int j = i;
                while (j < n1 && arr1[j] == 'X') ++j;
                if (j == n1 || arr1[j] != 'L') return false;
                swap(arr1, i, j);
                i = i + 1;
            } else if (c == 'R') {
                return false;
            } else {
                int j = i;
                while (j < n1 && arr1[j] == 'R') ++j;
                if (j == n1 || arr1[j] == 'L') return false;
                swap(arr1, i, j);
                i = i + 1;
            }
        }
        return true;
    }
    
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}