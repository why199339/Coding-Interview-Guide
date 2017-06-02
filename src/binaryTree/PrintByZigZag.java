package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class PrintByZigZag {

	public static void main(String[] args) {

	}

	public void printByZigZag(Node root) {
		if(root == null) {
			return;
		}
		Deque<Node> deque = new LinkedList<Node>();
		deque.offerFirst(root);
		Node last = root;
		Node nlast = null;
		boolean flag = true;
		while(!deque.isEmpty()) {
			Node node = null;
			if(flag) {
				node = deque.pollFirst();
				if(node.left != null) {
					deque.offerLast(node.left);
					nlast = nlast == null ? node.left : nlast;
				}
				if(node.right != null) {
					deque.offerLast(node.right);
					nlast = nlast == null ? node.right : nlast;
				}
			} else {
				node = deque.pollLast();
				if(node.right != null) {
					deque.offerFirst(node.right);
					nlast = nlast == null ? node.right : nlast;
				}
				if(node.left != null) {
					deque.offerFirst(node.left);
					nlast = nlast == null ? node.left : nlast;
				}
			}
			System.out.println(node.value + " ");
			if(node == last && !deque.isEmpty()) {
				flag = !flag;
				last = nlast;
				nlast = null;
				System.out.println();
			}
		}
		System.out.println();
	}
}
