package binaryTree;

public class PrintEdge {

	public static void main(String[] args) {

	}

	public void printEdge(Node root) {
		if(root == null) {
			return;
		}
		int h = getHeight(root);
		Node[][] edgeMap = new Node[h][2];
		setEdgeMap(root, 0, edgeMap);
		for(int i=0; i <h; i++) {
			System.out.println(edgeMap[i][0].value + " ");
		}
		printLeafNotInMap(root, 0, edgeMap);
		for(int i=h-1; i>=0; i--) {
			if(edgeMap[i][0] != edgeMap[i][1]) {
				System.out.println(edgeMap[i][1].value + " ");
			}
		}
	}

	private void printLeafNotInMap(Node root, int level, Node[][] edgeMap) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null && root != edgeMap[level][0] && root != edgeMap[level][1]) {
			System.out.println(root.value + " ");
		}
		printLeafNotInMap(root.left, level + 1, edgeMap);
		printLeafNotInMap(root.right, level + 1, edgeMap);
	}

	private void setEdgeMap(Node root, int level, Node[][] edgeMap) {
		if(root == null) {
			return;
		}
		edgeMap[level][0] = edgeMap[level][0] == null ? root : edgeMap[level][0];
		edgeMap[level][1] = root;
		setEdgeMap(root.left, level + 1, edgeMap);
		setEdgeMap(root.right, level + 1, edgeMap);
	}

	private int getHeight(Node root) {
		if(root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
}
