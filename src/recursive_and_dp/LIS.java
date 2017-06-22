package recursive_and_dp;

public class LIS {

	public static void main(String[] args) {

	}

	public int[] lis(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getDP(arr);
		return generate(arr, dp);
	}

	private int[] generate(int[] arr, int[] dp) {
		int len = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for (int i = index - 1; i >= 0; i--) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}

	private int[] getDP(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		int right = 0;
		dp[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			int l = 0;
			int r = right;
			while (l <= r) {
				int m = (l + r) / 2;
				if (ends[m] > arr[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			dp[i] = l + 1;
			ends[l] = arr[i];
		}
		return dp;
	}
}
