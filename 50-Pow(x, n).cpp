class Solution {
public:
	double myPow(double x, int n) {
		double result = 1.0;
		long long nn = labs(n);
		while (nn > 0) {
			double temp = x;
			long long mul = 1L;
			while (nn >= mul * 2L) {
				temp = temp * temp;
				mul = mul * 2L;
			}
			result *= temp;
			nn -= mul;
		}
		return n >= 0 ? result : 1.0 / result;
	}
};