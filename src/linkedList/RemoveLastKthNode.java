package linkedList;

public class RemoveLastKthNode {

	public static void main(String[] args) {

	}

	public Node removeLastKthNode(Node head, int k) {
		Node node = head;
		if (head == null || k < 1) {
			return head;
		}
		while (node != null) {
			k--;
			node = node.next;
		}
		if (k == 0) {
			return head.next;
		}
		if (k < 0) {
			node = head;
			while (++k < 0) {
				node = node.next;
			}
			node.next = node.next.next;
		}
		return head;
	}

	public DoubleNode reomveLastKthNode(DoubleNode head, int k) {
		if (head == null || k < 1) {
			return head;
		}
		DoubleNode node = head;
		while (node != null) {
			k--;
			node = node.next;
		}
		if (k == 0) {
			head.next.prev = null;
			return head.next;
		}
		if (k < 0) {
			node = head;
			while (++k < 0) {
				node = node.next;
			}
			node.next = node.next.next;
			if (node.next != null) {
				node.prev = node;
			}
		}
		return head;
	}
}
