class Solution {
    public List<Integer> lexicalOrder(int n) {
        if (n < 1) return new ArrayList<>();

        List<Integer> result = new ArrayList<>(n);
        result.add(1);
        while (result.size() < n) {
            int top = result.get(result.size() - 1);
            if (top * 10 <= n) {
                result.add(top * 10);
            } else if (top % 10 == 9) {
                top = top + 1;
                while (top % 10 == 0) {
                    top = top / 10;
                }
                result.add(top);
            } else if (top + 1 <= n) {
                result.add(top + 1);
            } else {
                top = top / 10 + 1;
                while (top % 10 == 0) {
                    top = top / 10;
                }
                result.add(top);
            }
        }
        return result;
    }
}
