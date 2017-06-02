package binaryTree;

import java.util.HashMap;

public class ReconstructTree {

	public static void main(String[] args) {

	}

	public Node preInToTree(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
	}

	private Node preIn(int[] pre, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map) {
		if (ps > pe) {
			return null;
		}
		Node root = new Node(pre[ps]);
		int index = map.get(pre[ps]);
		root.left = preIn(pre, ps + 1, ps + index - is, in, is, index - 1, map);
		root.right = preIn(pre, ps + index - is + 1, pe, in, index + 1, ie, map);
		return root;
	}

	public Node postIn(int[] post, int[] in) {
		if (post == null || in == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return postIn(post, 0, post.length - 1, in, 0, in.length - 1, map);
	}

	private Node postIn(int[] post, int ps, int pe, int[] in, int is, int ie, HashMap<Integer, Integer> map) {
		if (ps > pe) {
			return null;
		}
		Node root = new Node(post[pe]);
		int index = map.get(post[pe]);
		root.left = postIn(post, ps, ps + index - is - 1, in, is, index - 1, map);
		root.right = postIn(post, ps + index - is, pe - 1, in, index + 1, ie, map);
		return root;
	}
}
