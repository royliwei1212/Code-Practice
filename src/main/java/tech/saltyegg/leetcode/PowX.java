package tech.saltyegg.leetcode;

/**
 * Created by hzhou on 5/4/15. codeashobby@gmail.com
 */
public class PowX {

	public double myPow(double x, int n) {
		boolean isPositive = n > 0;
		double result = 1.0;
		n = n > 0 ? n : -n;
		while (n > 0) {
			if ((n & 1) == 1) {
				result *= x;
			}
			x *= x;
			n = n >> 1;
		}

		return isPositive ? result : (1.0 / result);
	}
}
