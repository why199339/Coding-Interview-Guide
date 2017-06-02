package binaryTree;

public class GenerateTree {

	public static void main(String[] args) {

	}

	public Node generateTree(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		return generate(arr, 0, arr.length - 1);
	}

	private Node generate(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		Node node = new Node(arr[mid]);
		node.left = generate(arr, start, mid - 1);
		node.right = generate(arr, mid + 1, end);
		return node;
	}
}
