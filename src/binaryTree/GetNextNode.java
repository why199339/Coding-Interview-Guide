package binaryTree;

public class GetNextNode {

	public static void main(String[] args) {

	}

	public Node getNextNode(Node root) {
		if(root == null) {
			return null;
		}
		if(root.right != null) {
			return getLeftMost(root.right);
		} else {
			Node parent = root.parent;
			while(parent != null && parent.left != root) {
				root = parent;
				parent = root.parent;
			}
			return parent;
		}
	}

	private Node getLeftMost(Node root) {
		if(root == null) {
			return root;
		}
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}
}
