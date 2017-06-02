package binaryTree;

import java.util.HashMap;

public class GetMaxLength {

	public static void main(String[] args) {

	}

	public int getMaxLength(Node root, int sum) {
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		sumMap.put(0, 0);
		return preOrder(root, sum, 0, 1, 0, sumMap);
	}
	
	private int preOrder(Node root, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
		if(root == null) {
			return maxLen;
		}
		int curSum = preSum + root.value;
		if(!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		if(sumMap.containsKey(curSum - sum)) {
			maxLen = Math.max(maxLen, level - sumMap.get(curSum - sum));
		}
		maxLen = preOrder(root.left, sum, curSum, level + 1, maxLen, sumMap);
		maxLen = preOrder(root.right, sum, curSum, level + 1, maxLen, sumMap);
		if(sumMap.get(curSum) == level) {
			sumMap.remove(curSum);
		}
		return maxLen;
	}
}
