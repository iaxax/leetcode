class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        int w = 0, h = 0;
        if (A <= E && E <= C) w = C - E;
        if (E <= A && C <= G) w = C - A;
        if (A <= G && G <= C) w = G - A;
        if (A <= E && G <= C) w = G - E;
        if (B <= H && H <= D) h = H - B;
        if (F <= B && D <= H) h = D - B;
        if (B <= F && F <= D) h = D - F;
        if (B <= F && H <= D) h = H - F;
        area -= w * h;
        return area;
    }
}

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int up = Math.min(D, H);
        int bottom = Math.max(B, F);
        if (left < right && bottom < up) {
            area -= (right - left) * (up - bottom);
        }
        return area;
    }
}
