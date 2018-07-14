class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            ++count[task - 'A'];
        }
        
        int maxLen = -1, num = 0;
        for (int i = 0; i < 26; ++i) {
            if (count[i] > maxLen) {
                maxLen = count[i];
                num = 1;
            } else if (count[i] == maxLen) {
                num += 1;
            }
        }
        return Math.max(tasks.length, (maxLen - 1) * (n + 1) + num);
    }
}
