class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for (char c : s1.toCharArray()) {
            count[c] += 1;
        }
        
        int len = s2.length(), num = s1.length();
        char[] record = new char[len];
        int l = 0, r = 0;
        while (r < len) {
            char c = s2.charAt(r);
            if (count[c] > 0) {
                --num;
                if (num == 0) return true;
                --count[c];
                record[r] = c;
                ++r;
            } else if (l <= r) {
                while (l <= r && record[l] == 0) ++l;
                if (l <= r) {
                    ++num;
                    ++count[record[l]];
                    record[l] = 0;
                    ++l;
                }
            } else {
                ++r;
            }
        }
        return false;
    }
}
