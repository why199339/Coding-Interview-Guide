package linkedList;

public class Convert {

	public static void main(String[] args) {

	}

	public Node convert(Node head) {
		Node lastNode = null;
		convertNode(head, lastNode);
		Node newHead = lastNode;
		while (newHead != null && newHead.left != null) {
			newHead = newHead.left;
		}
		return newHead;
	}

	private void convertNode(Node head, Node lastNode) {
		if (head == null) {
			return;
		}
		Node cur = head;
		if (cur.left != null) {
			convertNode(cur.left, lastNode);
		}
		cur.left = lastNode;
		if (lastNode != null) {
			lastNode.right = cur;
		}
		lastNode = cur;
		if (cur.right != null) {
			convertNode(cur.right, lastNode);
		}
	}
}
