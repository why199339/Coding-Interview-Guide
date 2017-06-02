package binaryTree;

import java.util.HashMap;

public class PreInToPost {

	public static void main(String[] args) {

	}

	public int[] preInToPost(int[] pre, int[] in) {
		if (pre == null || in == null) {
			return null;
		}
		int[] post = new int[in.length];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		setPos(pre, 0, pre.length - 1, in, 0, in.length - 1, post, post.length - 1, map);
		return post;
	}

	private int setPos(int[] pre, int ps, int pe, int[] in, int is, int ie, int[] post, int index,
			HashMap<Integer, Integer> map) {
		if (ps > pe) {
			return index;
		}
		post[index] = pre[ps];
		index--;
		int i = map.get(pre[ps]);
		index = setPos(pre, pe - ie + i + 1, pe, in, i + 1, ie, post, index, map);
		return setPos(pre, ps + 1, ps + i - is, in, is, i - 1, post, index, map);
	}
}
