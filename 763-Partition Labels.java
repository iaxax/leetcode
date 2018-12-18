class Solution {
    public List<Integer> partitionLabels(String S) {
        int[][] map = new int[128][2];
        for (int i = 'a'; i <= 'z'; ++i) {
            map[i][0] = map[i][1] = -1;
        }
        
        int n = S.length();
        for (int i = 0; i < n; ++i) {
            char c = S.charAt(i);
            if (map[c][0] == -1) {
                map[c][0] = i;
            }
            map[c][1] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int index = 0;
        while (index < n) {
            int begin = map[S.charAt(index)][0];
            int end = map[S.charAt(index)][1];
            for (int j = begin + 1; j < end; ++j) {
                char c = S.charAt(j);
                if (map[c][0] != -1) {
                    end = Math.max(end, map[c][1]);
                }
            }
            result.add(end - begin + 1);
            index = end + 1;
        }
        return result;
    }
}