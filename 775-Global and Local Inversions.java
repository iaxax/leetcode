class Solution {
    public boolean isIdealPermutation(int[] A) {
        int local = 0;
        for (int i = 1; i < A.length; ++i) {
            local += A[i] < A[i - 1] ? 1 : 0;
        }
        int[] global = new int[1];
        int[] a = mergeSort(A, 0, A.length - 1, global);
        return local == global[0];
    }
    
    private int[] mergeSort(int[] A, int begin, int end, int[] global) {
        if (begin == end) return new int[]{ A[begin] };
        
        int mid = (begin + end) >>> 1;
        int[] l = mergeSort(A, begin, mid, global);
        int[] r = mergeSort(A, mid + 1, end, global);
        return merge(l, r, global);
    }
    
    private int[] merge(int[] A, int[] B, int[] global) {
        int n1 = A.length, n2 = B.length;
        int n = n1 + n2;
        int[] result = new int[n];
        
        int i = 0, j = 0, k = 0;
        while (i < n1 || j < n2) {
            if (i >= n1 || (j < n2 && A[i] > B[j])) {
                result[k++] = B[j++];
                global[0] += n1 - i;
            } else if (j >= n2 || (i < n1 && A[i] < B[j])) {
                result[k++] = A[i++];
            }
        }
        
        return result;
    }
}

class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; ++i) {
            if (Math.abs(A[i] - i) > 1) return false;
        }
        return true;
    }
}