package binaryTree;

public class Recursive {

	public static void main(String[] args) {

	}

	public void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.value + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(Node root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.value + " ");
		inOrder(root.right);
	}
	
	public void postOrder(Node root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.value + " ");
	}
}
