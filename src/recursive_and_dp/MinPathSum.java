package recursive_and_dp;

public class MinPathSum {

	public static void main(String[] args) {

	}

	public int minPathSum1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for (int i = 1; i < col; i++) {
			dp[0][i] = dp[0][i - 1] + m[0][i];
		}
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	public int minPathSum2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int more = Math.max(m.length, m[0].length);
		int less = Math.min(m.length, m[0].length);
		boolean rowMore = (more == m.length);
		int[] dp = new int[less];
		dp[0] = m[0][0];
		for (int i = 1; i < less; i++) {
			dp[i] = dp[i - 1] + (rowMore ? m[0][i] : m[i][0]);
		}
		for (int i = 1; i < more; i++) {
			dp[0] = dp[0] + (rowMore ? m[i][0] : m[0][i]);
			for (int j = 1; j < less; j++) {
				dp[j] = Math.min(dp[j - 1], dp[j]) + (rowMore ? m[i][j] : m[j][i]);
			}
		}
		return dp[less - 1];
	}
}
