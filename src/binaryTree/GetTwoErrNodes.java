package binaryTree;

import java.util.Stack;

public class GetTwoErrNodes {

	public static void main(String[] args) {

	}

	public Node[] getTwoErrNodes(Node root) {
		if (root == null) {
			return null;
		}
		Node[] res = new Node[2];
		Stack<Node> stack = new Stack<Node>();
		Node prev = null;
		while(!stack.isEmpty() || root != null) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			} else {
				Node node = stack.pop();
				if(prev != null && prev.value > node.value) {
					res[0] = res[0] == null ? prev : res[0];
					res[1] = node;
				}
				prev = node;
				root = node.right;
			}
		}
		return res;
	}
}
