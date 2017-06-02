package binaryTree;

public class PostArrToBST {

	public static void main(String[] args) {

	}

	public Node postArrToBST(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		return post(arr, 0, arr.length - 1);
	}

	private Node post(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int less = -1;
		int more = end;
		Node node = new Node(arr[end]);
		for (int i = start; i < end; i++) {
			if (arr[end] > arr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		node.left = post(arr, start, less);
		node.right = post(arr, more, end - 1);
		return node;
	}
}
