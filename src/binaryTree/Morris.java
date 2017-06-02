package binaryTree;

public class Morris {

	public static void main(String[] args) {

	}

	public void morrisIn(Node root) {
		if(root == null) {
			return;
		}
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
			System.out.println(cur1.value + " ");
			cur1 = cur1.right;
		}
	}
	
	public void morrisPre(Node root) {
		if(root == null) {
			return;
		}
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
					System.out.println(cur1.value + " ");
					cur1 = cur1.left;
					continue;
				}
			} else {
				System.out.println(cur1.value + " ");
			}
			cur1 = cur1.right;
		}
	}
	
	
}
