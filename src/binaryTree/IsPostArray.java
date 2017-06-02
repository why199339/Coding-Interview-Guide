package binaryTree;

public class IsPostArray {

	public static void main(String[] args) {

	}

	public boolean isPostArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		return isPost(arr, 0, arr.length - 1);
	}

	private boolean isPost(int[] arr, int start, int end) {
		if (start == end) {
			return true;
		}
		int less = -1;
		int more = end;
		for (int i = start; i < end; i++) {
			if (arr[i] < end) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		if (less == -1 || more == end) {
			return isPost(arr, start, end - 1);
		}
		if (less != more - 1) {
			return false;
		}
		return isPost(arr, start, less) && isPost(arr, more, end - 1);
	}
}
