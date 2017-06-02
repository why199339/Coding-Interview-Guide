package binaryTree;

public class Contains {

	public static void main(String[] args) {

	}

	public boolean contains(Node root1, Node root2) {
		return check(root1, root2) || contains(root1.left, root2) || contains(root1.right, root2);
	}

	private boolean check(Node root1, Node root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.value != root2.value) {
			return false;
		}
		return check(root1.left, root2.left) && check(root1.right, root2.right);
	}
}
