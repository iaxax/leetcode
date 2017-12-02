class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        char[] arr = input.toCharArray();
        int n = arr.length;
        boolean isNumber = true;
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0, j = 0; i < n; i = j = j + 1) {
            while (j < n && arr[j] >= '0' && arr[j] <= '9') ++j;
            if (j == n) break;
            List<Integer> left = diffWaysToCompute(input.substring(0, j));
            List<Integer> right = diffWaysToCompute(input.substring(j + 1));
            for (int a : left) {
                for (int b : right) {
                    switch (arr[j]) {
                        case '+': result.add(a + b); break;
                        case '-': result.add(a - b); break;
                        case '*': result.add(a * b); break;
                    }
                }
            }
            isNumber = false;
        }
        
        if (isNumber) {
            result.add(Integer.valueOf(input));
            return result;
        }
        
        return result;
    }
}
