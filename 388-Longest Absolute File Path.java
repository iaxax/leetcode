class Solution {
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int i = 0;
        int size = input.length();
        while (i < size) {
            char c = input.charAt(i);
            if (c == '\n') {
                i += 1;
                continue;
            }

            int lv = 0;
            while (i < size && input.charAt(i) == '\t') {
                lv += 1;
                i += 1;
            }

            int len = 0;
            boolean isFile = false;
            while (i < size && input.charAt(i) != '\n' && input.charAt(i) != '\t') {
                len += 1;
                if (input.charAt(i) == '.') isFile = true;
                i += 1;
            }

            if (isFile) {
                int sum = 0;
                for (int j = 0; j < lv; ++j) {
                    sum += map.get(j);
                }
                maxLen = Math.max(maxLen, sum + len);
            } else {
                len += 1;
                if (map.containsKey(lv)) {
                    map.put(lv, len);
                } else {
                    map.put(lv, len);
                }
            }
        }

        return maxLen;
    }
}
