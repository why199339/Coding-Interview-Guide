package binaryTree;

public class MaxDistance {

	public static void main(String[] args) {

	}

	public int maxDistance(Node root) {
		int[] record = new int[1];
		return postOrder(root, record);
	}

	private int postOrder(Node root, int[] record) {
		if(root == null) {
			record[0] = 0;
			return 0;
		}
		int lMax = postOrder(root.left, record);
		int maxFromLeft = record[0];
		int rMax = postOrder(root.right, record);
		int maxFromRight = record[0];
		int maxFromRoot = maxFromLeft + maxFromRight + 1;
		record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
		int max = Math.max(maxFromRoot, Math.max(lMax, rMax));
		return max;
	}
}
