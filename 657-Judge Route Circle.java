class Solution {
    public boolean judgeCircle(String moves) {
        char[] arr = moves.toCharArray();
        int[] count = new int[256];
        for (char c : arr) {
            count[c] += 1;
        }
        return count['U'] == count['D'] && count['L'] == count['R'];
    }
}
