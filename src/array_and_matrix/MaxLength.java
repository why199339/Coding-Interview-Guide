package array_and_matrix;

import java.util.HashMap;

public class MaxLength {

	public static void main(String[] args) {

	}

	public int maxLength(int[] arr, int k) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int maxLen = 0;
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			if(map.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, i - map.get(sum - k));
			} 
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxLen;
	}
}
