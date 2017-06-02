package binaryTree;

public class BiggestSubBST {

	public static void main(String[] args) {

	}

	public Node biggestSubBST(Node root) {
		int[] record = new int[3];
		return postOrder(root, record);
	}

	private Node postOrder(Node root, int[] record) {
		if(root == null) {
			record[0] = 0;
			record[1] = Integer.MAX_VALUE;
			record[2] = Integer.MIN_VALUE;
		}
		Node left = postOrder(root.left, record);
		int lSize = record[0];
		int lMin = record[1];
		int lMax = record[2];
		Node right = postOrder(root.right, record);
		int rSize = record[0];
		int rMin = record[1];
		int rMax = record[2];
		int value = root.value;
		record[1] = Math.min(lMin, rMin);
		record[2] = Math.max(lMax, rMax);
		if(left == root.left && right == root.right && lMax < value && rMin > value) {
			record[0] = lSize + rSize + 1;
			return root;
		}
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize ? left : right;
	}
}
