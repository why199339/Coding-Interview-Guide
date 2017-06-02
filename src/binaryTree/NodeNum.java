package binaryTree;

public class NodeNum {

	public static void main(String[] args) {

	}

	public int nodeNum(Node root) {
		if (root == null) {
			return 0;
		}
		return bs(root, 1, mostLeftLevel(root, 1));
	}

	private int mostLeftLevel(Node root, int level) {
		while (root != null) {
			root = root.left;
			level++;
		}
		return level - 1;
	}

	private int bs(Node root, int l, int h) {
		if (l == h) {
			return 1;
		}
		if (mostLeftLevel(root.right, l + 1) == h) {
			return (1 << (h - 1)) + bs(root.right, l + 1, h);
		} else {
			return (1 << (h - l - 1)) + bs(root.left, l + 1, h);
		}
	}
}
