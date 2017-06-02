package linkedList;

public class RemoveMidNode {

	public static void main(String[] args) {

	}

	public Node removeMidNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			return head.next;
		}
		Node slow = head;
		Node fast = head.next.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	public Node removeByRatio(Node head, int a, int b) {
		if (a < 1 || b < 1) {
			return head;
		}
		int n = 0;
		Node node = head;
		while (node != null) {
			n++;
			node = node.next;
		}
		int k = (int) Math.ceil((double) (a * n) / (double) (b));
		if (k == 1) {
			return head.next;
		}
		if (k > 1) {
			node = head;
			while (--k != 1) {
				node = node.next;
			}
			node.next = node.next.next;
		}
		return head;
	}
}
