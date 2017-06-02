package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintByLevel {

	public static void main(String[] args) {

	}

	public void printByLevel(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		Node last = root;
		Node nlast = null;
		int level = 1;
		queue.offer(root);
		System.out.print(level + ":");
		level ++;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.value + " ");
			if(node.left != null) {
				queue.offer(node.left);
				nlast = node.left;
			}
			if(node.right != null) {
				queue.offer(node.right);
				nlast = node.right;
			}
			if(node == last && !queue.isEmpty()) {
				System.out.print("\n" + level + ":");
				last = nlast;
			}
		}
		System.out.println();
	}
}
