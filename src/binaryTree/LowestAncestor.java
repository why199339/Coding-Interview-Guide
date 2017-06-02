package binaryTree;

public class LowestAncestor {

	public static void main(String[] args) {

	}

	public Node lowestAncestor(Node root, Node o1, Node o2) {
		if(root == null || root == o1 || root == o2) {
			return root;
		}
		Node left = lowestAncestor(root.left, o1, o2);
		Node right = lowestAncestor(root.right, o1, o2);
		if(left != null && right != null) {
			return root;
		}
		if(left != null) {
			return left;
		} else {
			return right;
		}
	}
}
