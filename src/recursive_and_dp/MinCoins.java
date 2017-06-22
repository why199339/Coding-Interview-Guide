package recursive_and_dp;

public class MinCoins {

	public static void main(String[] args) {

	}

	public int minCoins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[n][aim + 1];
		for (int j = 1; j <= aim; j++) {
			dp[0][j] = max;
			if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
				dp[0][j] = dp[0][j - arr[0]] + 1;
			}
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
					left = dp[i][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(left, dp[i - 1][j]);
			}
		}
		return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
	}

	public int minCoins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[] dp = new int[aim + 1];
		for (int j = 1; j <= aim; j++) {
			dp[j] = max;
			if (j - arr[j] > 0 && dp[j - arr[0]] != max) {
				dp[j] = dp[j - arr[0]] + 1;
			}
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				left = max;
				if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
					left = dp[j - arr[i]] + 1;
				}
				dp[j] = Math.min(left, dp[j]);
			}
		}
		return dp[aim] != max ? dp[aim] : -1;
	}

	public int minCoins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int max = Integer.MAX_VALUE;
		int[][] dp = new int[arr.length][aim + 1];
		for (int j = 1; j <= aim; j++) {
			dp[0][j] = max;
		}
		if (arr[0] <= aim) {
			dp[0][arr[0]] = 1;
		}
		int leftup = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; i <= aim; j++) {
				leftup = max;
				if (j >= arr[i] && dp[i - 1][j - arr[i]] != max) {
					leftup = dp[i - 1][j - arr[i]] + 1;
				}
				dp[i][j] = Math.min(leftup, dp[i - 1][j]);
			}
		}
		return dp[arr.length - 1][aim] != max ? dp[arr.length - 1][aim] : -1;
	}

	public int minCoins4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int n = arr.length;
		int max = Integer.MAX_VALUE;
		int[] dp = new int[aim + 1];
		for (int j = 1; j <= aim; j++) {
			dp[j] = max;
		}
		if (aim >= arr[0]) {
			dp[arr[0]] = 1;
		}
		int left = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= aim; j++) {
				left = max;
				if (j >= arr[i] && dp[j - arr[i]] != max) {
					left = dp[j - arr[i]] + 1;
				}
				dp[j] = Math.min(left, dp[j]);
			}
		}
		return dp[aim] != max ? dp[aim] : -1;
	}
}
