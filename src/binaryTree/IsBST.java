package binaryTree;

public class IsBST {

	public static void main(String[] args) {

	}

	public boolean isBST(Node root) {
		if(root == null) {
			return true;
		}
		boolean res = true;
		Node prev = null;
		Node cur1 = root;
		Node cur2 = null;
		while(cur1 != null) {
			cur2 = cur1.left;
			if(cur2 != null) {
				while(cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if(cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			if(prev != null && prev.value > cur1.value) {
				res = false;
			}
			prev = cur1;
			cur1 = cur1.right;
		}
		return res;
	}
}
