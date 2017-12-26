class Solution {
    public int lastRemaining(int n) {
        int begin = 1, end = n, gap = 1;
        boolean fromLeft = true;
        while (begin < end) {
            if (fromLeft) {
                begin = begin + gap;
                gap <<= 1;
                end = begin + (end - begin) / gap * gap;
            } else {
                end = end - gap;
                gap <<= 1;
                begin = end - (end - begin) / gap * gap;
            }
            fromLeft = !fromLeft;
        }
        return begin;
    }
}
