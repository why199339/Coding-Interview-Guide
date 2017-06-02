package binaryTree;

import java.util.Stack;

public class Iterative {

	public static void main(String[] args) {

	}

	public void preOrder(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.value + " ");
			if(cur.right != null) {
				stack.push(cur.right);
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
		}
	}
	
	public void inOrder(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || root != null) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				Node cur = stack.pop();
				System.out.println(cur.value + " ");
				root = cur.right;
			}
		}
	}
	
	public void postOrder(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		while(!stack1.isEmpty()) {
			Node cur = stack1.pop();
			stack2.push(cur);
			if(cur.left != null) {
				stack2.push(cur.left);
			}
			if(cur.right != null) {
				stack2.push(cur.right);
			}
		}
		while(!stack2.isEmpty()) {
			Node node = stack2.pop();
			System.out.println(node.value + " ");
		}
	}
}
