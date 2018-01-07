class Solution {
    public String originalDigits(String s) {
        int[] map = new int[26];
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] index = {0, 6, 2, 8, 7, 5, 4, 9, 3, 1};
        for (char c : s.toCharArray()) {
            map[c - 'a'] += 1;
        }

        int[] count = new int[10];
        for (int i = 0; i < 10; ++i) {
            int num = minNum(map, digits[index[i]]);
            if (num > 0) {
                for (int j = 0; j < num; ++j) count[index[i]] += 1;
                for (char c : digits[index[i]].toCharArray()) map[c - 'a'] -= num;
            }
        }

        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                result.append(i);
            }
        }

        return result.toString();
    }

    private int minNum(int[] map, String digit) {
        int result = Integer.MAX_VALUE;
        for (char c : digit.toCharArray()) {
            result = Math.min(result, map[c - 'a']);
        }
        return result;
    }
}
