// slow solution
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int size = people.length;
        int[][] result = new int[size][2];
        for (int i = 0; i < size; ++i) {
            result[i][0] = people[i][0];
            result[i][1] = people[i][1];
        }
        
        Arrays.sort(result, (int[] a, int[] b) -> {
            return a[0] - b[0] != 0 ? b[0] - a[0] : a[1] - b[1];
        });
        
        for (int i = 0; i < size; ++i) {
            if (result[i][1] == i) continue;
            int[] temp = result[i];
            for (int j = i - 1; j >= temp[1]; --j) {
                result[j + 1] = result[j];
            }
            result[temp[1]] = temp;
        }
        return result;
    }
}

// faster solution
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int size = people.length;
        int[][] result = new int[size][2];
        for (int i = 0; i < size; ++i) {
            result[i][0] = people[i][0];
            result[i][1] = people[i][1];
        }
        
        sort(result, 0, size - 1);
        
        for (int i = 0; i < size; ++i) {
            if (result[i][1] == i) continue;
            int[] temp = result[i];
            for (int j = i - 1; j >= temp[1]; --j) {
                result[j + 1] = result[j];
            }
            result[temp[1]] = temp;
        }
        return result;
    }
    
    private void sort(int[][] arr, int start, int end) {
        if (end <= start) return;

        int left = start + 1, right = end;
        while (left <= right) {
            while (left <= right && compare(arr[left], arr[start]) <= 0) ++left;
            while (left <= right && compare(arr[right], arr[start]) > 0) --right;
            if (left > right) break;
            swap(arr, left, right);
        }
        swap(arr, start, left - 1);
        sort(arr, start, left - 1);
        sort(arr, left , end);
    }
    
    private int compare(int[] a, int[] b) {
        return a[0] - b[0] != 0 ? b[0] - a[0] : a[1] - b[1];
    }
    
    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
