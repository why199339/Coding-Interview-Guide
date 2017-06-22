package recursive_and_dp;

public class MakeChange {

	public static void main(String[] args) {

	}

	public int coins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return process1(arr, 0, aim);
	}

	private int process1(int[] arr, int index, int aim) {
		if (index == arr.length) {
			return (aim == 0) ? 1 : 0;
		}
		int res = 0;
		for (int i = 0; arr[index] * i <= aim; i++) {
			res += process1(arr, index + 1, aim - arr[index] * i);
		}
		return res;
	}

	public int coins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length][aim + 1];
		return process2(arr, 0, aim, map);
	}

	private int process2(int[] arr, int index, int aim, int[][] map) {
		if (index == arr.length) {
			return (aim == 0) ? 1 : 0;
		}
		int res = 0;
		for (int i = 0; arr[index] * i <= aim; i++) {
			int mapValue = map[index + 1][aim - arr[index] * i];
			if (mapValue != 0) {
				res += (res == -1) ? 0 : mapValue;
			} else {
				res += process2(arr, index + 1, aim - arr[index] * i, map);
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
		return res;
	}

	public int coins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j * arr[0] <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				int num = 0;
				for (int k = 0; k * arr[i] <= j; k++) {
					num += dp[i - 1][j - arr[i] * k];
				}
				dp[i][j] = num;
			}
		}
		return dp[arr.length - 1][aim];
	}

	public int coins4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j * arr[0] <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = (j >= arr[i]) ? dp[i - 1][j] + dp[i][j - arr[i]] : dp[i - 1][j];
			}
		}
		return dp[arr.length - 1][aim];
	}

	public int coins5(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return -1;
		}
		int[] dp = new int[aim + 1];
		for (int j = 0; j * arr[0] <= aim; j++) {
			dp[j * arr[0]] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[j] = j >= arr[i] ? dp[j] + dp[j - arr[i]] : dp[j];
			}
		}
		return dp[aim];
	}
}
