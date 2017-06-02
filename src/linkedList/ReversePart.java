package linkedList;

public class ReversePart {

	public static void main(String[] args) {

	}

	public Node reversePart(Node head, int from, int to) {
		int len = 0;
		Node fPrev = null;
		Node tNext = null;
		Node node1 = head;
		while (node1 != null) {
			len++;
			fPrev = (len == from - 1) ? node1 : fPrev;
			tNext = (len == to + 1) ? node1 : tNext;
			node1 = node1.next;
		}
		if (from > to || to > len || from < 1) {
			return head;
		}
		node1 = (fPrev == null) ? head : fPrev.next;
		Node node2 = node1.next;
		node1.next = tNext;
		while (node2 != tNext) {
			Node next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if (fPrev != null) {
			fPrev.next = node1;
			return head;
		}
		return node1;
	}
}
