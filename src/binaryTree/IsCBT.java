package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCBT {

	public static void main(String[] args) {

	}

	public boolean isCBT(Node root) {
		if(root == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		boolean leaf = false;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			Node left = node.left;
			Node right = node.right;
			if((leaf && (left != null || right != null)) || (left == null && right != null)) {
				return false;
			}
			if(left != null) {
				queue.offer(left);
			}
			if(right != null) {
				queue.offer(right);
			} else {
				leaf = true;
			}
		}
		return true;
	}
}
