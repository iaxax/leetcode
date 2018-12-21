class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] fullness = new double[101];
        fullness[0] = poured;
        for (int i = 0; i < 100; ++i) {
            double[] temp = new double[101];
            for (int j = 0; j <= i; ++j) {
                if (fullness[j] > 1) {
                    double spill = (fullness[j] - 1) / 2;
                    temp[j] += spill;
                    temp[j + 1] += spill;
                    fullness[j] = 1;
                }
            }
            if (i == query_row) return fullness[query_glass];
            fullness = temp;
        }
        return fullness[query_glass];
    }
}