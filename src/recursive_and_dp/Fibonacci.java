package recursive_and_dp;

public class Fibonacci {

	public static void main(String[] args) {

	}

	// O(n^2)
	public int f1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return f1(n - 1) + f1(n - 2);
	}

	// O(n)
	public int f2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int pre = 1;
		int res = 1;
		for (int i = 3; i <= n; i++) {
			int temp = res;
			res += pre;
			pre = temp;
		}
		return res;
	}

	// O(logN)
	public int f3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = new int[][] { { 1, 1 }, { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}

	private int[][] matrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		int[][] temp = m;
		while (p != 0) {
			if ((p & 1) == 1) {
				res = muliMatrix(res, temp);
			}
			temp = muliMatrix(temp, temp);
			p >>= 1;
		}
		return res;
	}

	private int[][] muliMatrix(int[][] m, int[][] n) {
		int[][] res = new int[m.length][n[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < n[0].length; j++) {
				for (int k = 0; k < n.length; k++) {
					res[i][j] += m[i][k] * n[k][j];
				}
			}
		}
		return res;
	}
}
