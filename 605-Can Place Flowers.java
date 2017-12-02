class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int[] bed = new int[length + 2];
        for (int i = 1; i <= length; ++i) bed[i] = flowerbed[i - 1];
        for (int i = 0; i <= length + 1;) {
            while (i <= length + 1 && bed[i] == 1) ++i;
            int left = i, right = i;
            while (right <= length + 1 && bed[right] == 0) ++right;
            i = right;
            int gap = right - left;
            n -= (gap - 1) / 2;
            if (n <= 0) break;
        }
        return n <= 0;
    }
}
