package stack_and_queue;

import java.util.Stack;

public class MaxRecSize {

	public static void main(String[] args) {

	}

	public static int maxRecSize(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				height[j] = matrix[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}

	private static int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int area = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int area = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}
}
