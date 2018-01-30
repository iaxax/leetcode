class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int row = wall.size(), max = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0, size = list.size();
            for (int i = 0; i < size - 1; ++i) {
                sum += list.get(i);
                Integer s = count.get(sum);
                if (s == null) {
                    count.put(sum, 1);
                    max = Math.max(max, 1);
                } else {
                    count.put(sum, s + 1);
                    max = Math.max(max, s + 1);
                }
            }
        }
        return row - max;
    }
}
