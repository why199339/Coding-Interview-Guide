package binaryTree;

import java.util.LinkedList;
import java.util.List;

public class NumTrees {

	public static void main(String[] args) {

	}

	public int numTrees(int n) {
		if (n < 2) {
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < i + 1; j++) {
				num[i] += num[j - 1] + num[i - j];
			}
		}
		return num[n];
	}

	public List<Node> generateTrees(int n) {
		return generate(1, n);
	}

	private List<Node> generate(int start, int end) {
		List<Node> res = new LinkedList<>();
		if (start > end) {
			return null;
		}
		for (int i = start; i <= end; i++) {
			Node root = new Node(i);
			List<Node> left = generate(start, i - 1);
			List<Node> right = generate(i + 1, end);
			for (Node lNode : left) {
				for (Node rNode : right) {
					root.left = lNode;
					root.right = rNode;
					res.add(cloneTree(root));
				}
			}
		}
		return res;
	}

	private Node cloneTree(Node root) {
		if (root == null) {
			return null;
		}
		Node res = new Node(root.value);
		res.left = cloneTree(root.left);
		res.right = cloneTree(root.right);
		return res;
	}
}
