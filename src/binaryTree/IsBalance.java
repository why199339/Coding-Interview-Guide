package binaryTree;

public class IsBalance {

	public static void main(String[] args) {

	}

	public boolean isBalance(Node root) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(root, 1, res);
		return res[0];
	}

	private int getHeight(Node root, int level, boolean[] res) {
		if(root == null) {
			return level;
		}
		int lHeight = getHeight(root.left, level + 1, res);
		if(!res[0]) {
			return level;
		}
		int rHeight = getHeight(root.right, level + 1, res);
		if(!res[0]) {
			return level;
		}
		if(Math.abs(lHeight - rHeight) > 1) {
			res[0] = false;
		}
		return Math.max(lHeight, rHeight);
	}
}
